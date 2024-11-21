package co.com.bck.domain.dto.numerofibonacci;

import co.com.bck.commons.utilities.ValidationGroup;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static co.com.bck.domain.constants.DomainErrors.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class NumeroFibonacciDto {

    private Long id;

    private Long idFibonacci;

    private Integer numero;

    // AUDITORIA
    @NotEmpty(groups = {ValidationGroup.OnCreate.class}, message = ERROR_CREATEBY_VACIO)
    private String createdBy;

    @NotEmpty(groups = {ValidationGroup.OnUpdate.class}, message = ERROR_UPDATEBY_VACIO)
    private String modifiedBy;

    private LocalDateTime dateCreated;

    private LocalDateTime dateModified;
}
