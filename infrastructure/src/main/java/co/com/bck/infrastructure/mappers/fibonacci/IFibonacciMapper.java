package co.com.bck.infrastructure.mappers.fibonacci;

import co.com.bck.domain.dto.fibonacci.FibonacciDto;
import co.com.bck.infrastructure.entities.fibonacci.Fibonacci;
import co.com.bck.infrastructure.mappers.IGenericMapper;
import co.com.bck.infrastructure.mappers.numerofibonacci.INumeroFibonacciMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {INumeroFibonacciMapper.class})
public interface IFibonacciMapper extends IGenericMapper<FibonacciDto, Fibonacci> {
    @Override
    Fibonacci toEntity(FibonacciDto fibonacciDto);

    @Override
    FibonacciDto toDto(Fibonacci fibonacci);
}
