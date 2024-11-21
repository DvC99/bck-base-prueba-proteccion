package co.com.bck.domain.queries;

import co.com.bck.commons.queries.QueryAbstract;
import co.com.bck.commons.exceptions.DomainException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * An abstract test class for query implementations.
 * This class provides a set of common test methods for validating the behavior of queries.
 *
 * @param <C> The type of the query context
 * @param <R> The type of the query result
 * @param <T> The type of the query extending QueryAbstract
 */
@ExtendWith(MockitoExtension.class)
public abstract class AbstractQueryTest<C, R, T extends QueryAbstract<C, R>> {

    protected T query;

    /**
     * Sets up the test environment before each test method.
     * Initializes the query object by calling the createQuery method.
     */
    @BeforeEach
    public void setUp() {
        query = createQuery();
    }

    /**
     * Creates and returns an instance of the query to be tested.
     *
     * @return A new instance of the query
     */
    protected abstract T createQuery();

    /**
     * Creates and returns a valid context for the query.
     *
     * @return A valid context object
     */
    protected abstract C createValidContext();

    /**
     * Creates and returns an invalid context for the query.
     *
     * @return An invalid context object
     */
    protected abstract C createInvalidContext();

    /**
     * Asserts that the result of the query execution is valid.
     *
     * @param result The result returned by the query execution
     */
    protected abstract void assertValidResult(R result);

    /**
     * Mocks any dependencies required for the query execution.
     */
    protected abstract void mockDependencies();

    /**
     * Tests the execution of the query with a valid context.
     * Mocks dependencies, creates a valid context, executes the query,
     * and asserts that the result is valid.
     */
    @Test
    public void testExecuteWithValidContext() {
        mockDependencies();
        C context = createValidContext();
        R result = query.execute(context);
        assertValidResult(result);
    }

    /**
     * Tests the execution of the query with an invalid context.
     * Expects a DomainException to be thrown.
     */
    @Test
    public void testExecuteWithInvalidContext() {
        C context = createInvalidContext();
        assertThrows(DomainException.class, () -> query.execute(context));
    }

    /**
     * Tests the pre-processing step of the query with a null context.
     * Expects a DomainException to be thrown.
     */
    @Test
    public void testPreProcessWithNullContext() {
        assertThrows(DomainException.class, () -> query.execute(null));
    }

    /**
     * Tests the order of method calls during query execution.
     * Verifies that preProcess, process, and postProcess methods are called in the correct order.
     */
    @Test
    public void testProcessOrder() {
        T spyQuery = spy(query);
        C context = createValidContext();
        
        spyQuery.execute(context);

        InOrder inOrder = inOrder(spyQuery);
        inOrder.verify(spyQuery).preProcess(context);
        inOrder.verify(spyQuery).process(context);
        inOrder.verify(spyQuery).postProcess(eq(context), any());
    }
}