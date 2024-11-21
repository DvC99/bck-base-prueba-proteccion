package co.com.bck.domain.commands.fibonacci;

import co.com.bck.commons.commands.CommandProcessAbstract;
import co.com.bck.commons.exceptions.DomainException;
import co.com.bck.domain.commands.numerofibonacci.CreateNumeroFibonaccCommand;
import co.com.bck.domain.dto.fibonacci.FibonacciDto;
import co.com.bck.domain.dto.numerofibonacci.NumeroFibonacciDto;
import co.com.bck.domain.services.fibonacci.IFibonacciService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static co.com.bck.domain.constants.DomainErrors.*;

@Slf4j
@Getter
@Setter
@Component
public class CreateFibonacciCommand extends CommandProcessAbstract<FibonacciDto,FibonacciDto > {
    private final IFibonacciService fibonacciService;
    private final CreateNumeroFibonaccCommand createFibonacciCommand;

    private List<NumeroFibonacciDto> series = new ArrayList<>();

    private FibonacciDto fibonacciDto;

    private NumeroFibonacciDto numeroFibonacciDtoRes;

    public CreateFibonacciCommand(IFibonacciService fibonacciService, CreateNumeroFibonaccCommand createFibonacciCommand) {
        this.fibonacciService = fibonacciService;
        this.createFibonacciCommand = createFibonacciCommand;
    }

    @Override
    protected void preProcess() throws DomainException {
        if (getContext() == null) {
            log.error(ERROR_CONTEXTO_VACIO);
            throw new DomainException(ERROR_CONTEXTO_VACIO);
        }
        setValid(true);
    }

    @Override
    protected void process() throws DomainException {
        LocalTime currentTime = getContext().getFecha();
        int seedX = currentTime.getMinute() % 100;
        int seedY = currentTime.getMinute() % 10;
        int numberOfElements = currentTime.getSecond();

        this.series.add(NumeroFibonacciDto.builder()
               .numero(seedX)
               .createdBy(getContext().getCreatedBy())
               .build());

        this.series.add(NumeroFibonacciDto.builder()
               .numero(seedY)
               .createdBy(getContext().getCreatedBy())
               .build());

        getContext().setSemillaX(seedX);
        getContext().setSemillaY(seedY);
        getContext().setCantidadNumeros(numberOfElements);

        this.calculateFibonacciSeries(numberOfElements);

        fibonacciDto = this.fibonacciService.save(getContext());


        setResult(this.fibonacciDto);
        getContext().setNumeroFibonacci(this.series);
        setExecuted(true);
    }

    @Override
    protected void postProcess() throws DomainException {
        log.info("Se ha creado el Fibonacci con ID: {}", fibonacciDto.getId());
        for (NumeroFibonacciDto numeroFibonacciDto : series) {
            createFibonacciCommand.setContext(numeroFibonacciDto);
            createFibonacciCommand.execute();
            numeroFibonacciDtoRes = createFibonacciCommand.getResult();
            log.info("Se ha creado el Número Fibonacci con ID: {}", numeroFibonacciDtoRes.getIdFibonacci());
        }
    }

    public void calculateFibonacciSeries(int numberOfElements) {
        for (int i = 2; i < numberOfElements; i++) {
            int nextNumber = this.series.get(i - 1).getNumero() + this.series.get(i - 2).getNumero();
            this.series.add(NumeroFibonacciDto.builder()
                    .idFibonacci(this.fibonacciDto.getId())
                    .numero(nextNumber)
                    .createdBy(getContext().getCreatedBy())
                    .build());
        }
    }
}
