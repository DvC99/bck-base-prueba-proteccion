package co.com.bck.commons.exceptions;

import lombok.extern.slf4j.Slf4j;

/**
 * Custom exception class for domain-specific errors.
 * This exception logs the error message using SLF4J logging framework.
 */
@Slf4j
public class DomainException extends RuntimeException {
    
    /**
     * Constructs a new DomainException with the specified detail message.
     * The message is passed to the parent constructor and logged as an error.
     *
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link #getMessage()} method)
     */
    public DomainException(String message) {
        super(message);
        log.error(message);
    }
}