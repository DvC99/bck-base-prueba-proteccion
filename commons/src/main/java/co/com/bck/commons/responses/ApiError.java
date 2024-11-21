package co.com.bck.commons.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents an API error response.
 */
@Getter
@Setter
public class ApiError {
    private int status;
    private String message;
    private Map<String, String> errors;

    /**
     * Constructs a new ApiError with the specified status and message.
     *
     * @param status  the HTTP status code of the error
     * @param message the general error message
     */
    public ApiError(int status, String message) {
        this.status = status;
        this.message = message;
        this.errors = new HashMap<>();
    }

    /**
     * Adds a specific error for a field to the errors map.
     *
     * @param fieldName    the name of the field with the error
     * @param errorMessage the error message for the field
     */
    public void addError(String fieldName, String errorMessage) {
        this.errors.put(fieldName, errorMessage);
    }
}
