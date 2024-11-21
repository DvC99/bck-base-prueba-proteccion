package co.com.bck.domain.commands;

import co.com.bck.commons.commands.CommandProcessAbstract;
import co.com.bck.commons.exceptions.DomainException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * An abstract test class for command process implementations.
 * This class provides a set of common test methods for validating the behavior of command processes.
 *
 * @param <C> The type of the command context
 * @param <R> The type of the command result
 * @param <T> The type of the command process extending CommandProcessAbstract
 */
@ExtendWith(MockitoExtension.class)
public abstract class AbstractCommandProcessTest<C, R, T extends CommandProcessAbstract<C, R>> {

    /**
     * Mock executor for testing multitasking mode.
     */
    @Mock
    protected ThreadPoolExecutor executor;

    /**
     * The command process instance being tested.
     */
    protected T command;

    /**
     * Sets up the test environment before each test method.
     * Creates a new command instance and sets its executor.
     */
    @BeforeEach
    public void setUp() {
        command = createCommand();
        command.setExecutor(executor);
    }

    /**
     * Creates an instance of the command process to be tested.
     *
     * @return A new instance of the command process
     */
    protected abstract T createCommand();

    /**
     * Creates a valid context for testing the command process.
     *
     * @return A valid context instance
     */
    protected abstract C createValidContext();

    /**
     * Creates an invalid context for testing error scenarios.
     *
     * @return An invalid context instance
     */
    protected abstract C createInvalidContext();

    /**
     * Asserts that the result of the command execution is valid.
     *
     * @param result The result returned by the command execution
     */
    protected abstract void assertValidResult(R result);

    protected abstract void setMethod();

    /**
     * Tests the execution of the command with a valid context.
     *
     * @throws DomainException if the command execution fails
     */
    @Test
    public void testExecuteWithValidContext() throws DomainException {
        C context = createValidContext();
        command.setContext(context);
        setMethod();
        command.execute();
        R result = command.getResult();
        assertValidResult(result);
        assertTrue(command.isExecuted());
    }

    /**
     * Tests the execution of the command with an invalid context.
     * Expects a DomainException to be thrown.
     */
    @Test
    public void testExecuteWithInvalidContext() {
        C context = createInvalidContext();
        command.setContext(context);
        assertThrows(DomainException.class, () -> command.execute());
        assertFalse(command.isExecuted());
    }

    /**
     * Tests the command execution in multitasking mode.
     *
     * @throws DomainException if the command execution fails
     */
    @Test
    public void testMultitaskingMode() throws DomainException {
        command.setMultitaskingMode(true);
        C context = createValidContext();
        command.setContext(context);
        command.execute();
        verify(executor, times(1)).execute(any(Runnable.class));
    }

    /**
     * Tests the command execution without transaction handling.
     *
     * @throws DomainException if the command execution fails
     */
    @Test
    public void testWithoutTransactionHandling() throws DomainException {
        command.setTransactionHandling(false);
        C context = createValidContext();
        command.setContext(context);
        setMethod();
        command.execute();
        R result = command.getResult();
        assertValidResult(result);
        assertTrue(command.isExecuted());
    }

    /**
     * Tests setting the context of the command.
     */
    @Test
    public void testSetContext() {
        C context = createValidContext();
        command.setContext(context);
        assertEquals(context, command.getContext());
    }

    /**
     * Tests retrieving the result of the command execution.
     *
     * @throws DomainException if the command execution fails
     */
    @Test
    public void testGetResult() throws DomainException {
        C context = createValidContext();
        command.setContext(context);
        setMethod();
        command.execute();
        R result = command.getResult();
        assertEquals(result, command.getResult());
    }
    
    /**
     * Prueba la ejecución del comando con un contexto proporcionado directamente.
     *
     * @throws DomainException si la ejecución del comando falla
     */
    @Test
    public void testExecuteWithProvidedContext() throws DomainException {
        C context = createValidContext();
        setMethod();
        R result = command.execute(context);
        assertValidResult(result);
        assertTrue(command.isExecuted());
        assertEquals(context, command.getContext());
    }

    /**
     * Tests the preProcess method of the command.
     * This method should be overridden by subclasses to test the specific
     * preProcess behavior of their commands.
     *
     * @throws DomainException if the preProcess execution fails
     */
    public abstract void testPreProcess() throws DomainException;

    /**
     * Tests the postProcess method of the command.
     * This method should be overridden by subclasses to test the specific
     * postProcess behavior of their commands.
     *
     * @throws DomainException if the postProcess execution fails
     */
    public abstract void testPostProcess() throws DomainException;
}