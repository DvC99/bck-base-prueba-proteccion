package co.com.bck.infrastructure.mappers.numerofibonacci;

import co.com.bck.domain.dto.numerofibonacci.NumeroFibonacciDto;
import co.com.bck.infrastructure.entities.numerofibonacci.NumeroFibonacci;
import co.com.bck.infrastructure.mappers.IGenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface INumeroFibonacciMapper extends IGenericMapper<NumeroFibonacciDto, NumeroFibonacci> {
    @Override
    @Mapping(source = "idFibonacci", target = "fibonacci.id")
    NumeroFibonacci toEntity(NumeroFibonacciDto numeroFibonacciDto);

    @Override
    @Mapping(source = "fibonacci.id", target = "idFibonacci")
    NumeroFibonacciDto toDto(NumeroFibonacci numeroFibonacci);
}
