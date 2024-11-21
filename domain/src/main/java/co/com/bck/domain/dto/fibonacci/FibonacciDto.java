package co.com.bck.domain.dto.fibonacci;

import co.com.bck.commons.utilities.ValidationGroup;
import co.com.bck.domain.dto.numerofibonacci.NumeroFibonacciDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static co.com.bck.domain.constants.DomainErrors.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class FibonacciDto {
    @NotNull(groups = {ValidationGroup.OnUpdate.class, ValidationGroup.OnDelete.class}, message = ERROR_ID_VACIO)
    private Long id;

    @NotNull(groups = {ValidationGroup.OnCreate.class, ValidationGroup.OnUpdate.class}, message = ERROR_ID_VACIO)
    private LocalTime fecha;

    private Integer cantidadNumeros;

    private Integer semillaX;

    private Integer semillaY;

    // NUMERO FIBONACCI
    private List<NumeroFibonacciDto> numeroFibonacci;

    // AUDITORIA
    @NotEmpty(groups = {ValidationGroup.OnCreate.class}, message = ERROR_CREATEBY_VACIO)
    private String createdBy;

    @NotEmpty(groups = {ValidationGroup.OnUpdate.class}, message = ERROR_UPDATEBY_VACIO)
    private String modifiedBy;

    private LocalDateTime dateCreated;

    private LocalDateTime dateModified;
}
