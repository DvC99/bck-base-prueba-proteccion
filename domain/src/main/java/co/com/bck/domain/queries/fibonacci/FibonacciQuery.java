package co.com.bck.domain.queries.fibonacci;

import co.com.bck.domain.dto.fibonacci.FibonacciDto;
import co.com.bck.domain.queries.AbstractDtoQuery;
import co.com.bck.domain.services.fibonacci.IFibonacciService;
import org.springframework.stereotype.Component;

@Component
public class FibonacciQuery extends AbstractDtoQuery<FibonacciDto, Long> {
    /**
     * Constructs an instance of FibonacciQuery with the provided IFibonacciService.
     * This class extends AbstractDtoQuery, which provides common functionality for querying DTOs.
     *
     * @param service The IFibonacciService instance used for retrieving elements.
     *                This service is responsible for implementing the business logic related to
     *                the Fibonacci entity and its associated operations.
     *
     * @see AbstractDtoQuery for more information on the parent class and its functionality.
     */
    protected FibonacciQuery(IFibonacciService service) {
        super(service);
    }
}