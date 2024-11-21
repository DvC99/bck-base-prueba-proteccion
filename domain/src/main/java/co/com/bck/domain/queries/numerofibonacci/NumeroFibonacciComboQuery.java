package co.com.bck.domain.queries.numerofibonacci;

import co.com.bck.domain.dto.numerofibonacci.NumeroFibonacciDto;
import co.com.bck.domain.queries.AbstractComboQuery;
import co.com.bck.domain.services.IGenericService;
import co.com.bck.domain.services.numerofibonacci.INumeroFibonacciService;
import org.springframework.stereotype.Component;

@Component
public class NumeroFibonacciComboQuery extends AbstractComboQuery<NumeroFibonacciDto, Long> {
    /**
     * Constructs an instance of NumeroFibonacciComboQuery with the specified generic service.
     * This constructor is used to initialize the parent class AbstractComboQuery with the provided
     * INumeroFibonacciService instance, allowing for combo operations related to NumeroFibonacciDto.
     *
     * @param service The INumeroFibonacciService instance to be used for combo operations.
     *                This service provides methods for retrieving and manipulating data related to
     *                NumeroFibonacciDto objects.
     */
    protected NumeroFibonacciComboQuery(INumeroFibonacciService service) {
        super(service);
    }
}
