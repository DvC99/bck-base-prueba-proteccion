package co.com.bck.infrastructure.services.pageable;

import co.com.bck.commons.pageable.IPageableResult;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Implementation of IPageableResult interface that wraps a Spring Data Page object.
 * This class provides methods to access pagination information and content of a page.
 *
 * @param <T> the type of elements in the page
 */
@AllArgsConstructor
public class PageableResultImpl<T> implements IPageableResult<T> {

    private final Page<T> page;

    /**
     * Retrieves the content of the current page.
     *
     * @return a List containing the elements of the current page
     */
    @Override
    public List<T> getContent() {
        return page.getContent();
    }

    /**
     * Gets the current page number.
     *
     * @return the zero-based page number of the current page
     */
    @Override
    public int getPageNumber() {
        return page.getNumber();
    }

    /**
     * Gets the size of the current page.
     *
     * @return the number of elements in the current page
     */
    @Override
    public int getPageSize() {
        return page.getSize();
    }

    /**
     * Gets the total number of elements across all pages.
     *
     * @return the total number of elements
     */
    @Override
    public Long getTotalElements() {
        return page.getTotalElements();
    }

    /**
     * Gets the total number of pages.
     *
     * @return the total number of pages
     */
    @Override
    public int getTotalPages() {
        return page.getTotalPages();
    }
}
