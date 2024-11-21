package co.com.bck.infrastructure.services.finonacci;

import co.com.bck.domain.dto.fibonacci.FibonacciDto;
import co.com.bck.domain.services.fibonacci.IFibonacciService;
import co.com.bck.infrastructure.entities.fibonacci.Fibonacci;
import co.com.bck.infrastructure.mappers.IGenericMapper;
import co.com.bck.infrastructure.mappers.fibonacci.IFibonacciMapper;
import co.com.bck.infrastructure.repositories.IGenericJpaRepository;
import co.com.bck.infrastructure.repositories.fibonacci.IFibonacciRepository;
import co.com.bck.infrastructure.services.GenericServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service implementation for Fibonacci operations.
 * This class extends the GenericServiceImpl and implements the IFibonacciService interface.
 * It provides methods for performing CRUD operations, as well as custom methods for Fibonacci-specific logic.
 */
@Service
@AllArgsConstructor
public class FibonacciServiceImpl extends GenericServiceImpl<FibonacciDto, Fibonacci, Long> implements IFibonacciService {
    private final IFibonacciRepository fibonacciRepository;
    private final IFibonacciMapper fibonacciMapper;

    @Override
    protected IGenericJpaRepository<Fibonacci, Long> getRepository() {
        return this.fibonacciRepository;
    }

    @Override
    protected IGenericMapper<FibonacciDto, Fibonacci> getMapper() {
        return this.fibonacciMapper;
    }

    /**
     * Checks if a Fibonacci entity with the given ID exists in the database.
     *
     * @param id The ID of the Fibonacci entity to check.
     * @return True if the entity exists, false otherwise.
     */
    @Override
    public boolean existById(Long id) {
        return this.fibonacciRepository.existsById(id);
    }

    /**
     * Checks if a Fibonacci entity is used in other tables in the database.
     *
     * @param tableName The name of the table to check for usage.
     * @return True if the entity is used in other tables, false otherwise.
     */
    @Override
    public boolean isUsedInOtherTables(String tableName) {
        return this.fibonacciRepository.isUsedInOtherTables(tableName);
    }
}
