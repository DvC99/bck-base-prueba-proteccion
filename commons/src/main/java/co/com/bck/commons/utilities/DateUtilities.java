package co.com.bck.commons.utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class DateUtilities {
    // Constructor privado para evitar la creación de instancias
    private DateUtilities() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
    // Método para convertir Date a String en formato "dd/MM/yyyy"
    public static String formatDateToSimple(Date date) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleFormat.format(date);
    }

    // Método para convertir LocalDateTime a String en formato "dd/MM/yyyy"
    public static String formatDateTimeToSimple(LocalDateTime dateTime) {
        Date date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        return formatDateToSimple(date);
    }

    // Método para convertir Date a String en formato "dd de MMMM de yyyy"
    public static String formatDateToLong(Date date) {
        SimpleDateFormat longFormat = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", Locale.forLanguageTag("es-ES"));
        return longFormat.format(date);
    }

    // Método para convertir LocalDateTime a String en formato "dd de MMMM de yyyy"
    public static String formatDateTimeToLong(LocalDateTime dateTime) {
        Date date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        return formatDateToLong(date);
    }
}
