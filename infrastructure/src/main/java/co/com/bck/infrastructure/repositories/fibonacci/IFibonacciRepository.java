package co.com.bck.infrastructure.repositories.fibonacci;

import co.com.bck.infrastructure.entities.fibonacci.Fibonacci;
import co.com.bck.infrastructure.repositories.IGenericJpaRepository;

public interface IFibonacciRepository extends IGenericJpaRepository<Fibonacci, Long> {
}
