package co.com.bck.infrastructure.mappers;

/**
 * A generic mapper interface for converting between DTOs and entities.
 *
 * @param <T> The DTO type
 * @param <E> The entity type
 */
public interface IGenericMapper<T, E> {

    /**
     * Converts an entity to its corresponding DTO.
     *
     * @param entity The entity to be converted
     * @return The resulting DTO
     */
    T toDto(E entity);

    /**
     * Converts a DTO to its corresponding entity.
     *
     * @param dto The DTO to be converted
     * @return The resulting entity
     */
    E toEntity(T dto);
}
