package co.com.bck.domain.queries;

import co.com.bck.commons.exceptions.DomainException;
import co.com.bck.commons.queries.QueryAbstract;
import co.com.bck.domain.services.IGenericService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static co.com.bck.domain.constants.DomainErrors.*;

/**
 * An abstract class for handling combo queries, extending QueryAbstract.
 * This class provides a generic implementation for processing combo-related operations.
 *
 * @param <T> The type of the context and result elements
 * @param <K> The type of the key used in the generic service
 */
@Slf4j
public abstract class AbstractComboQuery <T, K> extends QueryAbstract<T, List<T>> {
    private final IGenericService<T,K> service;

    /**
     * Constructs an AbstractComboQuery with the specified generic service.
     *
     * @param service The generic service to be used for combo operations
     */
    protected AbstractComboQuery(IGenericService<T, K> service) {
        this.service = service;
    }

    /**
     * Performs pre-processing checks on the given context.
     * Throws a DomainException if the context is null.
     *
     * @param context The context to be pre-processed
     * @throws DomainException if the context is null
     */
    @Override
    public void preProcess(T context) {
        if (context == null) {
            log.error(ERROR_CONTEXTO_VACIO);
            throw new DomainException(ERROR_CONTEXTO_VACIO);
        }
    }

    /**
     * Processes the combo query using the given context.
     *
     * @param context The context for processing the combo query
     * @return A List of type T containing the results of the combo query
     */
    @Override
    public List<T> process(T context) {
        return this.service.getComboSencillo(context);
    }
}
