package co.com.bck.domain.commands.numerofibonacci;

import co.com.bck.commons.commands.CommandProcessAbstract;
import co.com.bck.commons.exceptions.DomainException;
import co.com.bck.domain.dto.numerofibonacci.NumeroFibonacciDto;
import co.com.bck.domain.services.numerofibonacci.INumeroFibonacciService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static co.com.bck.domain.constants.DomainErrors.ERROR_CONTEXTO_VACIO;

@Slf4j
@Getter
@Setter
@Component
public class CreateNumeroFibonaccCommand extends CommandProcessAbstract<NumeroFibonacciDto,NumeroFibonacciDto > {
    private final INumeroFibonacciService numeroFibonacciService;

    public CreateNumeroFibonaccCommand(INumeroFibonacciService numeroFibonacciService) {
        this.numeroFibonacciService = numeroFibonacciService;
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
        setResult(this.numeroFibonacciService.save(getContext()));
        setExecuted(true);
    }

    @Override
    protected void postProcess() throws DomainException {
        // No hay postProcess aquí
    }
}
