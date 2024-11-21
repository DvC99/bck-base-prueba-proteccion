package co.com.bck.infrastructure.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Comments {
    //AUDITORIA
    public static final String CREATED_AT_COMMENT = "Fecha de creacion del registro";
    public static final String CREATED_BY_COMMENT = "Usuario de creacion del registro";
    public static final String MODIFIED_AT_COMMENT = "Fecha de modificacion del registro";
    public static final String MODIFIED_BY_COMMENT = "Usuario de modificacion del registro";
    
    //CAMPOS GENERALES
    public static final String PRIMARY_KEY_COMMENT = "Llave primaria de la tabla.";
    public static final String CODIGO_COMMENT = "Código del registro.";
    public static final String NOMBRE_COMMENT = "Nombre del registro.";

    // NUMERO FIBONACCI
    public static final String NUMERO_FIBONACCI_SEQ = "Numero de la secuencia de fibonacci.";
    public static final String FOREING_KEY_FIBONACCI = "ID de la tabla FIBONACCI.";
    public static final String FOREING_KEY_NUMERO_FIBONACCI = "ID de la tabla NUMERO FIBONACCI.";

    //CONCEPTO
    public static final String CUENTA_PERSUASIVO_DEBITO_COMMENT = "Cuenta persuasiva de débito";
    public static final String CUENTA_PERSUASIVO_CREDITO_COMMENT = "Cuenta persuasiva de crédito";
    public static final String CUENTA_COACTIVO_DEBITO_COMMENT = "Cuenta coactivo de débito";
    public static final String CUENTA_COACTIVO_CREDITO_COMMENT = "Cuenta coactivo de crédito";

}