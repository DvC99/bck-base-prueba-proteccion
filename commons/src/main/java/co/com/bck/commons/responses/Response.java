package co.com.bck.commons.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * Represents a generic response object for API communications.
 *
 * @param <T> The type of data contained in the body response.
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {
    /**
     * Indicates whether the operation was successful.
     */
    private boolean ok;

    /**
     * The status code of the response.
     */
    private Integer codigo;

    /**
     * A message providing additional information about the response.
     */
    private String mensaje;

    /**
     * The body of the response, containing the actual data.
     */
    private BodyResponse<T> cuerpo;
}
