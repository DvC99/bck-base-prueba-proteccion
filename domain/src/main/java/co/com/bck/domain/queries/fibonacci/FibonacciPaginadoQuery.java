package co.com.bck.domain.queries.fibonacci;

import co.com.bck.domain.dto.fibonacci.FibonacciDto;
import co.com.bck.domain.queries.AbstractPaginadoQuery;
import co.com.bck.domain.services.fibonacci.IFibonacciService;
import org.springframework.stereotype.Component;

@Component
public class FibonacciPaginadoQuery extends AbstractPaginadoQuery<FibonacciDto, Long> {
    /**
     * Constructor for FibonacciPaginadoQuery. This class is responsible for handling pagination-related
     * operations for retrieving Fibonacci numbers from the database.
     *
     * @param service The IFibonacciService interface, which provides methods for interacting with the
     *                Fibonacci number data. This service is used to perform data operations in the constructor.
     *                The service is passed as a dependency to the superclass AbstractPaginadoQuery.
     */
    protected FibonacciPaginadoQuery(IFibonacciService service) {
        super(service);
    }
}
