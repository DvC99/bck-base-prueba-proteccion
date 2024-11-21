package co.com.bck.infrastructure.services;

import co.com.bck.commons.exceptions.InfrastructureException;
import co.com.bck.commons.pageable.IPageableResult;
import co.com.bck.domain.services.IGenericService;
import co.com.bck.infrastructure.mappers.IGenericMapper;
import co.com.bck.infrastructure.repositories.IGenericJpaRepository;
import co.com.bck.infrastructure.services.pageable.PageableResultImpl;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static co.com.bck.infrastructure.constants.Generals.*;

/**
 * Abstract base class for generic service implementations.
 *
 * @param <T> The DTO type
 * @param <E> The entity type
 * @param <K> The key type
 */
public abstract class GenericServiceImpl<T, E, K> implements IGenericService<T, K> {

    /**
     * Get the repository for this service.
     *
     * @return The JPA repository for the entity type
     */
    protected abstract IGenericJpaRepository<E, K> getRepository();

    /**
     * Get the mapper for this service.
     *
     * @return The mapper for converting between DTO and entity types
     */
    protected abstract IGenericMapper<T, E> getMapper();

    /**
     * Retrieves a simple combo list based on the provided DTO.
     *
     * @param dto The DTO containing filter criteria
     * @return A list of DTOs matching the criteria
     */
    @Override
    public List<T> getComboSencillo(T dto) {
        Example<E> example = Example.of(getMapper().toEntity(dto));
        return getRepository().findAll(example).stream().map(getMapper()::toDto).toList();
    }

    /**
     * Retrieves a paginated combo list based on the provided DTO and pagination parameters.
     *
     * @param dto The DTO containing filter criteria
     * @param pageNumber The page number to retrieve
     * @param pageSize The number of items per page
     * @return A pageable result containing DTOs matching the criteria
     */
    @Override
    public IPageableResult<T> getComboGrande(T dto, int pageNumber, int pageSize) {
        Example<E> example = Example.of(getMapper().toEntity(dto));
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<E> page = getRepository().findAll(example, pageRequest);
        return new PageableResultImpl<>(page.map(getMapper()::toDto));
    }

    /**
     * Retrieves a single element by its key.
     *
     * @param k The key of the element to retrieve
     * @return The DTO of the retrieved element
     * @throws InfrastructureException if the element is not found
     */
    @Override
    @Transactional
    public T getElement(K k) {
        return getMapper().toDto(getRepository().findById(k).orElseThrow(() -> new InfrastructureException(ERROR_NO_REGISTRO_BY_ID.replace(TOKEN_REPLACE, String.valueOf(k)))));
    }

    /**
     * Saves a new element.
     *
     * @param dto The DTO of the element to save
     * @return The DTO of the saved element
     */
    @Override
    @Transactional
    public T save(T dto) {
        return getMapper().toDto(getRepository().save(getMapper().toEntity(dto)));
    }

    /**
     * Updates an existing element.
     *
     * @param dto The DTO of the element to update
     * @return The updated DTO
     * @throws InfrastructureException as this operation is not supported by default
     */
    @Override
    @Transactional
    public T update(T dto) {
        return getMapper().toDto(getRepository().save(getMapper().toEntity(dto)));
    }

    /**
     * Deletes an element by its key.
     *
     * @param k The key of the element to delete
     * @return The DTO of the deleted element
     */
    @Override
    @Transactional
    public T delete(K k) {
        T dto = getMapper().toDto(getRepository().getReferenceById(k));
        getRepository().deleteById(k);
        return dto;
    }
}
