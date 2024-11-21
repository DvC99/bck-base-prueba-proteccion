package co.com.bck.infrastructure.controllers.fibonacci;

import co.com.bck.commons.context.PageContext;
import co.com.bck.commons.responses.ComboResponse;
import co.com.bck.commons.responses.Response;
import co.com.bck.commons.responses.ResponseBuilder;
import co.com.bck.commons.utilities.ValidationGroup;
import co.com.bck.domain.commands.fibonacci.CreateFibonacciCommand;
import co.com.bck.domain.dto.fibonacci.FibonacciDto;
import co.com.bck.domain.queries.fibonacci.FibonacciComboQuery;
import co.com.bck.domain.queries.fibonacci.FibonacciPaginadoQuery;
import co.com.bck.domain.queries.fibonacci.FibonacciQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

import static co.com.bck.infrastructure.constants.Constant.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = URL_BASE_FIBONACCI, produces = MediaType.APPLICATION_JSON_VALUE)
public class FibonacciController {
    private FibonacciQuery fibonacciQuery;
    private FibonacciPaginadoQuery fibonacciPaginadoQuery;
    private FibonacciComboQuery fibonacciComboQuery;
    private CreateFibonacciCommand createFibonacciCommand;

    @Operation(description = API_OPERATION_GET_FIBONACCI_PAGED)
    @GetMapping(MAPPING_GET_FIBONACCI_PAGED)
    public Response<FibonacciDto> getPaginado(
            @Parameter(description = DESCRIPCION_ID, example = EXAMPLE_ID)
            @RequestParam(required = false) Long id,
            @Parameter(description = DESCRIPCION_FECHA, example = EXAMPLE_FECHA)
            @RequestParam(required = false) LocalTime fecha,
            @Parameter(description = DESCRIPCION_CANTIDAD_NUMEROS, example = EXAMPLE_CANTIDAD_NUMEROS)
            @RequestParam(required = false) Integer cantidadNumeros,
            @Parameter(description = DESCRIPCION_SEMILLA_X, example = EXAMPLE_SEMILLA_X)
            @RequestParam(required = false) Integer semillaX,
            @Parameter(description = DESCRIPCION_SEMILLA_Y, example = EXAMPLE_SEMILLA_Y)
            @RequestParam(required = false) Integer semillaY,
            @Parameter(description = PAG_INICIO)
            @RequestParam(defaultValue = PAG_INICIO_DEFAULT_VALUE) Integer pagInicio,
            @Parameter(description = PAG_TAMANIO )
            @RequestParam(defaultValue = PAG_TAMANIO_DEFAULT_VALUE) Integer pagTamanio ){
        PageContext<FibonacciDto> context = PageContext.<FibonacciDto>builder()
                .data(FibonacciDto.builder()
                        .id(id)
                        .fecha(fecha)
                        .cantidadNumeros(cantidadNumeros)
                        .semillaX(semillaX)
                        .semillaY(semillaY)
                        .build()
                )
                .pageNumber(pagInicio)
                .pageSize(pagTamanio)
                .build();
        return ResponseBuilder.sysTableResponse(this.fibonacciPaginadoQuery.execute(context));
    }

    @Operation(description = API_OPERATION_GET_FIBONACCI_COMBO)
    @GetMapping(MAPPING_GET_FIBONACCI_COMBO)
    public ComboResponse<FibonacciDto> getCombo() {
        return ResponseBuilder.sysComboResponse(this.fibonacciComboQuery.execute(FibonacciDto.builder().build()));
    }

    @Operation(description = API_OPERATION_GET_FIBONACCI_BY_ID)
    @GetMapping(MAPPING_GET_FIBONACCI_BY_ID)
    public Response<FibonacciDto> getDto(
            @Parameter(description = DESCRIPCION_ID, example = EXAMPLE_ANIO_ID)
            @RequestParam Long id) {
        return ResponseBuilder.genericResponse(this.fibonacciQuery.execute(id));
    }

    @Operation(description = API_OPERATION_POST_FIBONACCI)
    @PostMapping(MAPPING_POST_FIBONACCI)
    public Response<FibonacciDto> create(
            @Parameter(description = DESCRIPTION_FIBONACCI_DTO)
            @Validated(ValidationGroup.OnCreate.class)
            @RequestBody FibonacciDto fibonacciDto) {
        this.createFibonacciCommand.setContext(fibonacciDto);
        this.createFibonacciCommand.execute();
        return ResponseBuilder.genericResponse(this.createFibonacciCommand.getResult());
    }
}
