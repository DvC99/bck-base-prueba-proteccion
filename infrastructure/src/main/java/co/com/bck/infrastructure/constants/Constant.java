package co.com.bck.infrastructure.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {
    public static final String URL_BASE = "bck-base-prueba-proteccion/servicio/";

    // CONSTANTES GENERALES
    public static final String PAG_INICIO = "Pagina inicio";
    public static final String PAG_INICIO_DEFAULT_VALUE = "0";
    public static final String PAG_TAMANIO = "Tamanio pagina";
    public static final String PAG_TAMANIO_DEFAULT_VALUE = "999999";
    public static final String EXAMPLE_ANIO_ID = "1";
    public static final String DESCRIPCION_ID = "Id del registro";
    public static final String EXAMPLE_ID = "1";

    // FIBONACCI
    public static final String URL_BASE_FIBONACCI = URL_BASE + "fibonacci";
    public static final String MAPPING_GET_FIBONACCI_PAGED = "/get_fibonacci_paginado";
    public static final String API_OPERATION_GET_FIBONACCI_PAGED = "Get paginado para la tabla Fibonacci";
    public static final String MAPPING_GET_FIBONACCI_COMBO = "/get_fibonacci_combo";
    public static final String API_OPERATION_GET_FIBONACCI_COMBO = "Get combo para la tabla Fibonacci";
    public static final String MAPPING_GET_FIBONACCI_BY_ID = "/get_fibonacci";
    public static final String API_OPERATION_GET_FIBONACCI_BY_ID = "Get una secuencia de la serie Fibonacci por id";
    public static final String MAPPING_POST_FIBONACCI = "/post_fibonacci";
    public static final String API_OPERATION_POST_FIBONACCI = "Post para guardar una secuencia de la serie Fibonacci";
    public static final String DESCRIPTION_FIBONACCI_DTO = "FibonacciDTO";
    public static final String DESCRIPCION_FECHA = "Fecha inical para el calculo";
    public static final String EXAMPLE_FECHA = "12:23:04";
    public static final String DESCRIPCION_CANTIDAD_NUMEROS = "Cantidad de numeros generados para la seire";
    public static final String EXAMPLE_CANTIDAD_NUMEROS = "5";
    public static final String DESCRIPCION_SEMILLA_X = "Primer valor inicial para el calculo del la serie";
    public static final String EXAMPLE_SEMILLA_X = "3";
    public static final String DESCRIPCION_SEMILLA_Y = "Segundo valor para el calculo de la serie";
    public static final String EXAMPLE_SEMILLA_Y = "4";

}