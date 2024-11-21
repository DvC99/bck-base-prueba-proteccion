package co.com.bck.commons.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Represents a generic response structure for architectural purposes.
 * This class is designed to encapsulate response data including a status code, 
 * a message, and a body containing a list of elements.
 *
 * @param <T> the type of elements in the response body
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ResponseArqB<T> implements Serializable {
    /**
     * The status code of the response.
     */
    private Integer codigo;

    /**
     * A message describing the response or providing additional information.
     */
    private String mensaje;

    /**
     * The body of the response, containing a list of elements of type T.
     * This field is marked as transient to exclude it from serialization if needed.
     */
    private transient List<T> cuerpo;
}
