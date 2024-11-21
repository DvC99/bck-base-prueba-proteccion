package co.com.bck.commons.exceptions;

import lombok.extern.slf4j.Slf4j;

/**
 * Represents an application-specific exception.
 * This exception is used to wrap and handle application-specific errors.
 */
@Slf4j
public class ApplicationException extends RuntimeException {
    
    /**
     * Constructs a new ApplicationException with the specified detail message.
     * The message is also logged as an error.
     *
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link #getMessage()} method and logged as an error)
     */
    public ApplicationException(String message) {
        super(message);
        log.error(message);
    }
}
