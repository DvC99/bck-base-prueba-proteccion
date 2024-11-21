package co.com.bck.domain.services;

import co.com.bck.commons.pageable.IPageableResult;

import java.util.List;

/**
 * Generic service interface for common CRUD operations and data retrieval.
 *
 * @param <T> The type of the DTO (Data Transfer Object)
 * @param <K> The type of the identifier
 */
public interface IGenericService<T, K> {

    /**
     * Retrieves a paginated result of items based on the provided DTO and pagination parameters.
     *
     * @param dto        The DTO containing filter criteria
     * @param pageNumber The number of the page to retrieve
     * @param pageSize   The number of items per page
     * @return A pageable result containing the requested items
     */
    IPageableResult<T> getComboGrande(T dto, int pageNumber, int pageSize);

    /**
     * Retrieves a simple list of items based on the provided DTO.
     *
     * @param dto The DTO containing filter criteria
     * @return A list of items matching the criteria
     */
    List<T> getComboSencillo(T dto);
    
    /**
     * Retrieves a single element by its identifier.
     *
     * @param id The unique identifier of the element to retrieve
     * @return The element corresponding to the given identifier, or null if not found
     */
    T getElement(K id);
    
    /**
     * Saves a new item.
     *
     * @param dto The DTO containing the item data to be saved
     * @return The saved item
     */
    T save(T dto);

    /**
     * Updates an existing item.
     *
     * @param dto The DTO containing the updated item data
     * @return The updated item
     */
    T update(T dto);

    /**
     * Deletes an item by its identifier.
     *
     * @param id The identifier of the item to be deleted
     * @return The deleted item
     */
    T delete(K id);

    /**
     * Checks if an item exists in the system based on its unique identifier.
     *
     * @param id The unique identifier of the item to check for existence
     * @return true if an item with the given identifier exists, false otherwise
     */
    boolean existById(K id);

    /**
     * Checks if the specified item is referenced in other tables.
     *
     * @param tableName The name of the table to exclude from the reference check
     * @return true if the item is referenced in tables other than the specified one, false otherwise
     */
    boolean isUsedInOtherTables(String tableName);
}
