package co.com.bck.domain.queries;

import co.com.bck.commons.exceptions.DomainException;
import co.com.bck.commons.queries.QueryAbstract;
import co.com.bck.domain.services.IGenericService;
import lombok.extern.slf4j.Slf4j;

import static co.com.bck.domain.constants.DomainErrors.*;

/**
 * An abstract base class for DTO (Data Transfer Object) queries.
 * This class extends QueryAbstract and provides a generic implementation
 * for processing queries related to DTOs.
 *
 * @param <T> The type of the DTO
 * @param <K> The type of the identifier used to retrieve the DTO
 */
@Slf4j
public abstract class AbstractDtoQuery <T, K> extends QueryAbstract<K,T> {
    private final IGenericService<T,K> service;

    /**
     * Constructs an AbstractDtoQuery with the specified generic service.
     *
     * @param service The generic service used for retrieving elements
     */
    protected AbstractDtoQuery(IGenericService<T, K> service) {
        this.service = service;
    }

    /**
     * Performs pre-processing checks before executing the main query.
     * Validates that the provided identifier is not null.
     *
     * @param id The identifier to be pre-processed
     * @throws DomainException if the identifier is null
     */
    @Override
    public void preProcess(K id) {
        if (id == null) {
            log.error(ERROR_CONTEXTO_VACIO);
            throw new DomainException(ERROR_CONTEXTO_VACIO);
        }
    }

    /**
     * Processes the query by retrieving the element associated with the given identifier.
     *
     * @param id The identifier of the element to be retrieved
     * @return The element of type T associated with the given identifier
     */
    @Override
    public T process(K id) {
        return this.service.getElement(id);
    }
}
