package co.com.bck.commons.utilities;

import co.com.bck.commons.exceptions.InfrastructureException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for handling object attributes.
*/
@Component
public class ObjectUtilities {
    /**
     * Retrieves the value of a specified attribute from an object.
     *
     * @param object The object from which to retrieve the attribute
     * @param name   The name of the attribute to retrieve
     * @return The value of the specified attribute
     * @throws InfrastructureException if there's a problem retrieving the attribute
     */
    public Object getAttribute(Object object, String name) {
        try {
            return BeanUtils.getProperty(object, name);
        } catch (Exception e) {
            throw new InfrastructureException("Problemas al obtener el atributo: " + name);
        }
    }

    /**
     * Retrieves a list attribute from an object.
     *
     * @param object The object from which to retrieve the list attribute
     * @param name   The name of the list attribute to retrieve
     * @return A List containing the elements of the attribute
     * @throws InfrastructureException if the attribute is not a list or array, or if there's a problem retrieving it
     */
    public List<Object> getListAttribute(Object object, String name) {
        try {
            Object value = PropertyUtils.getProperty(object, name);

            if (value != null && value.getClass().isArray()) {
                List<Object> list = new ArrayList<>();
                int length = Array.getLength(value);

                for (int i = 0; i < length; i++) {
                    Object element = Array.get(value, i);
                    list.add(element);
                }

                return list;
            } else if (value instanceof List) {
                return new ArrayList<>((List<?>) value);
            } else {
                throw new InfrastructureException("La propiedad " + name + " no es una lista");
            }
        } catch (Exception e) {
            throw new InfrastructureException("Problemas al obtener la lista: " + name, e);
        }
    }

    /**
     * Retrieves a string attribute from an object.
     *
     * @param object The object from which to retrieve the string attribute
     * @param name   The name of the string attribute to retrieve
     * @return The string value of the attribute, or an empty string if retrieval fails
     */
    public String getStringAttribute(Object object, String name) {
        try {
            return BeanUtils.getProperty(object, name);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Retrieves an integer attribute from an object.
     *
     * @param object The object from which to retrieve the integer attribute
     * @param name   The name of the integer attribute to retrieve
     * @return The integer value of the attribute, or null if retrieval or parsing fails
     */
    public Integer getIntegerAttribute(Object object, String name) {
        try {
            String value = BeanUtils.getProperty(object, name);
            if (value != null) {
                return Integer.parseInt(value);
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    /**
     * Retrieves a long attribute from an object.
     *
     * @param object The object from which to retrieve the long attribute
     * @param name   The name of the long attribute to retrieve
     * @return The long value of the attribute, or null if retrieval or parsing fails
     */
    public Long getLongAttribute(Object object, String name) {
        try {
            String value = BeanUtils.getProperty(object, name);
            if (value != null) {
                return Long.parseLong(value);
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    /**
     * Retrieves a boolean attribute from an object.
     *
     * @param object The object from which to retrieve the boolean attribute
     * @param name   The name of the boolean attribute to retrieve
     * @return The boolean value of the attribute, or false if retrieval or parsing fails
     */
    public Boolean getBooleanAttribute(Object object, String name) {
        try {
            String value = BeanUtils.getProperty(object, name);
            if (value != null) {
                return Boolean.parseBoolean(value);
            }
        } catch (Exception e) {
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }
}
