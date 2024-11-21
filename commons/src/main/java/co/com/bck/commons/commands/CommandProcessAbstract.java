package co.com.bck.commons.commands;

import co.com.bck.commons.exceptions.DomainException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.concurrent.*;

/**
 * An abstract class representing a command process that can be executed in various modes.
 * This class provides a framework for implementing command pattern with pre-processing,
 * main processing, and post-processing steps.
 *
 * @param <C> The type of the context object used in the command process.
 * @param <R> The type of the result returned by the command process.
 */
@Slf4j
@Setter
@Getter
@Component
public abstract class CommandProcessAbstract<C, R> {

    protected R result;

    protected C context;

    protected boolean isExecuted = false;

    protected boolean isValid;

    protected boolean isMultitaskingMode = false;

    protected boolean isTransactionHandling = true;

    @Autowired
    private Executor executor;

    @Autowired
    private TransactionTemplate transactionTemplate;

    /**
     * Performs pre-processing steps before the main process execution.
     *
     * @throws DomainException if an error occurs during pre-processing.
     */
    protected abstract void preProcess() throws DomainException;

    /**
     * Executes the main process of the command.
     *
     * @throws DomainException if an error occurs during the main process execution.
     */
    protected abstract void process() throws DomainException;

    /**
     * Performs post-processing steps after the main process execution.
     *
     * @throws DomainException if an error occurs during post-processing.
     */
    protected abstract void postProcess() throws DomainException;

    /**
     * Executes the command process with the given context.
     * This method sets the context and then calls the parameterless execute() method.
     *
     * @param context The context object for the command process.
     * @return The result of the command execution.
     * @throws DomainException If an error occurs during the command execution.
     */
    public R execute(C context) throws DomainException {
        this.context = context;
        return execute();
    }

    /**
     * Executes the command process.
     * If multitasking mode is enabled, the execution is performed asynchronously.
     * Otherwise, it's performed synchronously.
     *
     * @return The result of the command execution.
     * @throws DomainException If an error occurs during the command execution.
     */
    public R execute() throws DomainException {
        if (isMultitaskingMode) {
            CompletableFuture.runAsync(this::executeInternal, executor);
        } else {
            executeInternal();
        }
        return result;
    }

    /**
     * Executes the internal steps of the command process.
     * This method performs pre-processing, main processing (if valid),
     * and post-processing (if executed) steps in order.
     *
     * @throws DomainException If an error occurs during any step of the execution.
     */
    public void executeInternal() throws DomainException {
        try {
            preProcess();
            if (isValid) {
                process();
            }
            if (isExecuted) {
                postProcess();
            }
        } catch (DomainException e) {
            log.error("Error in command process {}: {}", this.getClass().getSimpleName(), e.getMessage(), e);
            throw new DomainException(e.getMessage());
        }
    }
}