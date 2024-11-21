package co.com.bck.domain.queries.numerofibonacci;

import co.com.bck.domain.dto.numerofibonacci.NumeroFibonacciDto;
import co.com.bck.domain.queries.AbstractDtoQuery;
import co.com.bck.domain.services.IGenericService;
import co.com.bck.domain.services.numerofibonacci.INumeroFibonacciService;
import org.springframework.stereotype.Component;

@Component
public class NumeroFibonacciQuery extends AbstractDtoQuery<NumeroFibonacciDto, Long> {
    /**
     * Constructs an instance of NumeroFibonacciQuery with the provided INumeroFibonacciService.
     * This class extends AbstractDtoQuery, which provides common functionality for querying DTOs.
     *
     * @param service The INumeroFibonacciService instance used for retrieving elements.
     *                This service is responsible for implementing the business logic related to
     *                the NumeroFibonacci entity and its associated operations.
     *
     * @see AbstractDtoQuery for more information on the parent class and its functionality.
     */
    protected NumeroFibonacciQuery(INumeroFibonacciService service) {
        super(service);
    }
}
