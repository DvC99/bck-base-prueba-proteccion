package co.com.bck.commons.responses;

import co.com.bck.commons.pageable.IPageableResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResponseBuilder {
    private ResponseBuilder() {
        // Private constructor to prevent instantiation
    }

    /**
     * Creates a table response from a pageable result.
     *
     * @param <T>  the type of elements in the result
     * @param list the pageable result containing the items and metadata
     * @return a Response object containing the data and metadata from the pageable result
     */
    public static <T> Response<T> sysTableResponse(IPageableResult<T> list) {
        if (list.getTotalElements() == 0) {
            return Response.<T>builder()
                    .ok(true)
                    .codigo(0)
                    .cuerpo(BodyResponse.<T>builder()
                            .conteo(0)
                            .datos(Collections.emptyList())
                            .build())
                    .build();
        }
        return Response.<T>builder()
                .ok(true)
                .codigo(0)
                .cuerpo(BodyResponse.<T>builder()
                        .conteo(Integer.parseInt(list.getTotalElements().toString()))
                        .datos(list.getContent())
                        .build())
                .build();
    }

    /**
     * Partitions a list into smaller sublists of a specified size.
     *
     * @param <T>  the type of elements in the list
     * @param list the list to be partitioned
     * @param size the maximum size of each partition
     * @return a list of sublists, each containing at most 'size' elements from the original list
     */
    public static <T> List<List<T>> partition(List<T> list, int size) {
        int n = list.size();
        List<List<T>> result = new ArrayList<>();
        for (int i = 0; i < n; i += size) {
            result.add(list.subList(i, Math.min(i + size, n)));
        }
        return result;
    }

    /**
     * Creates a combo response containing a list of items.
     *
     * @param <T>  the type of elements in the list
     * @param list the list of items to be included in the response
     * @return a ComboResponse object containing the list of items and metadata
     */
    public static <T> ComboResponse<T> sysComboResponse(List<T> list) {
        return ComboResponse.<T>builder()
                .ok(true)
                .codigo(0)
                .mensaje("ok")
                .cuerpo(list)
                .build();
    }

    /**
     * Interprets an Integer value as a Boolean for Sysman's generic parameter handling.
     *
     * @param value the Integer value to be interpreted
     * @return true if the value is less than 0, false if it's 0 or greater, or null if the input is null
     */
    public static Boolean interpretParameterBooleanGenericSysman(Integer value) {
        return value == null ? null : value < 0;
    }

    /**
     * Creates a generic response containing a single object.
     *
     * @param <T> the type of the object
     * @param obj the object to be included in the response
     * @return a Response object containing the single object and metadata
     */
    public static <T> Response<T> genericResponse(T obj) {
        return Response.<T>builder()
                .ok(true)
                .codigo(0)
                .cuerpo(BodyResponse.<T>builder()
                        .conteo(1)
                        .datos(Collections.singletonList(obj))
                        .build())
                .build();
    }
}