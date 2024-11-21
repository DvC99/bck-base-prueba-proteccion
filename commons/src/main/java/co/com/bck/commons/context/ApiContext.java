package co.com.bck.commons.context;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Represents the context for an API operation, containing both data and parameters.
 *
 * @param <T> The type of data contained in this context.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class ApiContext<T> {
    /**
     * The main data object associated with this API context.
     */
    private T data;

    /**
     * A map of additional parameters associated with this API context.
     * The keys are parameter names, and the values are their corresponding string representations.
     */
    private Map<String, String> params;
}
