package co.com.bck.domain.queries;

import co.com.bck.commons.context.PageContext;
import co.com.bck.commons.exceptions.DomainException;
import co.com.bck.commons.pageable.IPageableResult;
import co.com.bck.commons.queries.QueryAbstract;
import co.com.bck.domain.services.IGenericService;
import lombok.extern.slf4j.Slf4j;

import static co.com.bck.domain.constants.DomainErrors.ERROR_CONTEXTO_VACIO;

/**
 * An abstract class for handling paginated queries.
 * This class extends QueryAbstract and provides a template for processing paginated data.
 *
 * @param <T> The type of data being queried
 * @param <K> The type of key used in the generic service
 */
@Slf4j
public abstract class AbstractPaginadoQuery<T, K> extends QueryAbstract<PageContext<T>, IPageableResult<T>> {
    private final IGenericService<T,K> service;

    /**
     * Constructor for AbstractPaginadoQuery.
     *
     * @param service The generic service used for data operations
     */
    protected AbstractPaginadoQuery(IGenericService<T, K> service) {
        this.service = service;
    }

    /**
     * Pre-processes the query context.
     * Checks if the provided context is not null, throwing an exception if it is.
     *
     * @param context The page context containing query parameters
     * @throws DomainException if the context is null
     */
    @Override
    public void preProcess(PageContext<T> context) {
        if (context == null) {
            log.error(ERROR_CONTEXTO_VACIO);
            throw new DomainException(ERROR_CONTEXTO_VACIO);
        }
    }

    /**
     * Processes the query and retrieves the paginated result.
     *
     * @param context The page context containing query parameters
     * @return An IPageableResult containing the paginated data
     */
    @Override
    public IPageableResult<T> process(PageContext<T> context) {
        return this.service.getComboGrande(context.getData(), context.getPageNumber(), context.getPageSize());
    }
}
