package co.com.bck.infrastructure.services.numerofibonacci;

import co.com.bck.domain.dto.numerofibonacci.NumeroFibonacciDto;
import co.com.bck.domain.services.numerofibonacci.INumeroFibonacciService;
import co.com.bck.infrastructure.entities.numerofibonacci.NumeroFibonacci;
import co.com.bck.infrastructure.mappers.IGenericMapper;
import co.com.bck.infrastructure.mappers.numerofibonacci.INumeroFibonacciMapper;
import co.com.bck.infrastructure.repositories.IGenericJpaRepository;
import co.com.bck.infrastructure.repositories.numerofibonacci.INumeroFibonacciRepository;
import co.com.bck.infrastructure.services.GenericServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service implementation for managing NumeroFibonacci entities.
 * This class extends the GenericServiceImpl and implements the INumeroFibonacciService interface.
 * It provides methods for interacting with the NumeroFibonacci repository and mapper.
 */
@Service
@AllArgsConstructor
public class NumeroFibonacciServiceImpl extends GenericServiceImpl<NumeroFibonacciDto, NumeroFibonacci, Long> implements INumeroFibonacciService {

    /**
     * Repository for managing NumeroFibonacci entities.
     */
    private final INumeroFibonacciRepository repository;

    /**
     * Mapper for converting between NumeroFibonacciDto and NumeroFibonacci entities.
     */
    private final INumeroFibonacciMapper mapper;

    /**
     * {@inheritDoc}
     * Returns the NumeroFibonacci repository.
     */
    @Override
    protected IGenericJpaRepository<NumeroFibonacci, Long> getRepository() {
        return this.repository;
    }

    /**
     * {@inheritDoc}
     * Returns the NumeroFibonacci mapper.
     */
    @Override
    protected IGenericMapper<NumeroFibonacciDto, NumeroFibonacci> getMapper() {
        return this.mapper;
    }

    /**
     * Checks if a NumeroFibonacci entity with the given id exists in the database.
     *
     * @param id The id of the NumeroFibonacci entity to check.
     * @return True if the entity exists, false otherwise.
     */
    @Override
    public boolean existById(Long id) {
        return this.repository.existsById(id);
    }

    /**
     * Checks if the NumeroFibonacci entity is used in other tables in the database.
     *
     * @param tableName The name of the table to check for usage.
     * @return True if the entity is used in other tables, false otherwise.
     */
    @Override
    public boolean isUsedInOtherTables(String tableName) {
        return this.repository.isUsedInOtherTables(tableName);
    }
}
