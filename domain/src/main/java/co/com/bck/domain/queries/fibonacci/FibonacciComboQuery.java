package co.com.bck.domain.queries.fibonacci;

import co.com.bck.domain.dto.fibonacci.FibonacciDto;
import co.com.bck.domain.queries.AbstractComboQuery;
import co.com.bck.domain.services.fibonacci.IFibonacciService;
import org.springframework.stereotype.Component;

@Component
public class FibonacciComboQuery extends AbstractComboQuery<FibonacciDto, Long> {
    /**
     * Constructs an instance of FibonacciComboQuery with the specified generic service.
     * This constructor is used to initialize the parent class AbstractComboQuery with the provided
     * IFibonacciService instance, allowing for combo operations related to FibonacciDto.
     *
     * @param service The IFibonacciService instance to be used for combo operations.
     *                This service provides methods for retrieving and manipulating data related to
     *                FibonacciDto objects.
     */
    protected FibonacciComboQuery(IFibonacciService service) {
        super(service);
    }
}
