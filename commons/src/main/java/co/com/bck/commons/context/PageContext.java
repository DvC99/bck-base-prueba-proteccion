package co.com.bck.commons.context;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a context for paginated data.
 * This class is used to encapsulate pagination information along with the actual data.
 *
 * @param <T> the type of data being paginated
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class PageContext<T> {
    /**
     * The actual data content of the page.
     */
    private T data;

    /**
     * The current page number.
     */
    private Integer pageNumber;

    /**
     * The number of items per page.
     */
    private Integer pageSize;
}
