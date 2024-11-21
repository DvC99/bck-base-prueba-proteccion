package co.com.bck.commons.exceptions;

import co.com.bck.commons.responses.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Global exception handler for the application.
 * This class handles various types of exceptions and provides appropriate responses.
 */
@Slf4j
@RestControllerAdvice
public class ErrorHandlerConfig extends ResponseEntityExceptionHandler  {

    /**
     * Handles all uncaught exceptions.
     *
     * @param e The exception that was thrown.
     * @return A ResponseEntity containing an error response with INTERNAL_SERVER_ERROR status.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> all(Exception e) {
        log.error(e.getMessage());
        log.error(e.getLocalizedMessage());
        Response<Object> response = new Response<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value() , e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles ApplicationExceptions.
     *
     * @param e The ApplicationException that was thrown.
     * @return A ResponseEntity containing an error response with INTERNAL_SERVER_ERROR status.
     */
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Object> applicationException(ApplicationException e) {
        log.error(e.getMessage());
        log.error(e.getLocalizedMessage());
        Response<Object> response = new Response<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value() , e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles DomainExceptions.
     *
     * @param e The DomainException that was thrown.
     * @return A ResponseEntity containing an error response with BAD_REQUEST status.
     */
    @ExceptionHandler(DomainException.class)
    public ResponseEntity<Object> domainException(DomainException e) {
        log.error(e.getMessage());
        log.error(e.getLocalizedMessage());
        Response<Object> response = new Response<>(false,HttpStatus.BAD_REQUEST.value(), e.getMessage() , null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles InfrastructureExceptions.
     *
     * @param e The InfrastructureException that was thrown.
     * @return A ResponseEntity containing an error response with INTERNAL_SERVER_ERROR status.
     */
    @ExceptionHandler(InfrastructureException.class)
    public ResponseEntity<Object> infrastructureException(InfrastructureException e) {
        log.error(e.getMessage());
        log.error(e.getLocalizedMessage());
        Response<Object> response = new Response<>(false,HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage() , null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles MethodArgumentNotValidException which occurs when @Valid fails.
     *
     * @param ex The MethodArgumentNotValidException that was thrown.
     * @param headers The headers to be written to the response.
     * @param status The selected response status.
     * @param request The current request.
     * @return A ResponseEntity containing an error response with details of validation failures.
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        StringBuilder errorMessage = new StringBuilder("Error: ");
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String message = error.getDefaultMessage();
            errorMessage.append(message).append(". ");
        });
        if (!errorMessage.isEmpty()) {
            errorMessage.setLength(errorMessage.length() - 1);
        }
        Response<Object> response = new Response<>(false, status.value(), errorMessage.toString(), null);
        return new ResponseEntity<>(response, status);
    }

    /**
     * Handles DataIntegrityViolationException which can occur due to various database constraint violations,
     * including foreign key constraints.
     *
     * @param e The DataIntegrityViolationException that was thrown.
     * @return A ResponseEntity containing an error response with BAD_REQUEST status.
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException e) {
        log.error("Data integrity violation: {}", e.getMessage());
        String userFriendlyMessage = "No se puede realizar la operación debido a una violación de integridad de datos.";
        if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
            userFriendlyMessage = "No se puede eliminar este registro porque está siendo utilizado en otra parte del sistema.";
        }
        Response<Object> response = new Response<>(false, HttpStatus.BAD_REQUEST.value(), userFriendlyMessage, null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
