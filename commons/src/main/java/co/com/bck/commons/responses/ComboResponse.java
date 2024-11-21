package co.com.bck.commons.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Represents a generic response object for combo-related operations.
 * This class encapsulates the result of an operation, including status, code, message, and a list of items.
 *
 * @param <T> the type of elements in the response body
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public final class ComboResponse<T> implements Serializable {
    /**
     * Indicates whether the operation was successful.
     */
    private boolean ok;

    /**
     * The status code of the response.
     */
    private Integer codigo;

    /**
     * A descriptive message about the response or operation result.
     */
    private String mensaje;

    /**
     * The list of items returned in the response.
     * This field is marked as transient to exclude it from serialization.
     */
    private transient List<T> cuerpo;
}
