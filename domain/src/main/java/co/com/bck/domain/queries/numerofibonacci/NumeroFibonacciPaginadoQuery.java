package co.com.bck.domain.queries.numerofibonacci;

import co.com.bck.domain.dto.numerofibonacci.NumeroFibonacciDto;
import co.com.bck.domain.queries.AbstractPaginadoQuery;
import co.com.bck.domain.services.numerofibonacci.INumeroFibonacciService;
import org.springframework.stereotype.Component;

@Component
public class NumeroFibonacciPaginadoQuery extends AbstractPaginadoQuery<NumeroFibonacciDto, Long> {
    /**
     * Constructor for NumeroFibonacciPaginadoQuery. This class is responsible for handling pagination-related
     * operations for retrieving Fibonacci numbers from the database.
     *
     * @param service The INumeroFibonacciService interface, which provides methods for interacting with the
     *                Fibonacci number data. This service is used to perform data operations in the constructor.
     *                The service is passed as a dependency to the superclass AbstractPaginadoQuery.
     */
    protected NumeroFibonacciPaginadoQuery(INumeroFibonacciService service) {
        super(service);
    }
}
