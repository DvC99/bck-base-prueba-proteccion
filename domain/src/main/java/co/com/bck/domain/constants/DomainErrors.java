package co.com.bck.domain.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DomainErrors {
    // VARIABLES DE REMPLAZO
    public static final String TOKEN_CAMPO = "CAMPO";
    public static final String TOKEN_REPLACE = "REPLACE";

    // MENSAJES DE ERROR GENERICOS - VACIOS
    public static final String ERROR_ID_VACIO = "El ID no puede estar vacío";
    public static final String ERROR_CODIGO_VACIO = "El Código no puede estar vacío";
    public static final String ERROR_NOMBRE_VACIO = "El Nombre no puede estar vacío";
    public static final String ERROR_CONTEXTO_VACIO = "El contexto de la consulta es nulo.";
    public static final String ERROR_CREATEBY_VACIO = "El nombre de usuario que crea el registro es obligatorio";
    public static final String ERROR_UPDATEBY_VACIO = "El nombre de usuario que modifica el registro es obligatorio";


    // MENSAJES DE ERROR GENERICOS - NO EXISTENTE
    public static final String ERROR_CAMPO_VALOR_EXISTENTE = "El valor REPLACE a ingresar en el CAMPO, ya existe.";
    public static final String ERROR_NOT_EXIST_ID = "No existe el registro para el ID : REPLACE";
    public static final String ERROR_NOT_PROCESS_IS_USED_OTHER_TABLES = "Error: El ID REPLACE está siendo utilizado en otras tablas y no puede ser editado";
    public static final String ERROR_CODIGO_EXISTENTE = "El código : REPLACE ya existe.";

    // CONSTANTES PARA TIPOS
    public static final String ERROR_ID_TIPO_VACIO = "El ID del tipo no puede estar vacío";

    //CONCEPTO
    public static final String ERROR_CUENTA_DEBITO_PERSUACIVO_VACIO = "La cuenta de débito persuasivo no puede estar vacía.";
    public static final String ERROR_CUENTA_CREDITO_PERSUACIVO_VACIO = "La cuenta de crédito persuasivo no puede estar vacía.";
    public static final String ERROR_CUENTA_DEBITO_COACTIVO_VACIO = "La cuenta de débito coactivo no puede estar vacía.";
    public static final String ERROR_CUENTA_CREDITO_COACTIVO_VACIO = "La cuenta de crédito coactivo no puede estar vacía.";

    // FIBONACCI
    public static final String ERROR_SEMILLA_X_VACIO = "La semilla X no puede estar vaciá";
    public static final String ERROR_SEMILLA_Y_VACIO = "La semilla Y no puede estar vaciá";
    public static final String ERROR_CANTIDAD_NUMEROS_VACIO = "La cantidad de números generar, no puede estar vaciá";
    public static final String ERROR_NUMEROS_VACIO = "El numero genrado esta vacio";
}