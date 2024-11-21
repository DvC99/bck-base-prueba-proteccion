package co.com.bck.infrastructure.routing.rest;

import co.com.bck.commons.exceptions.InfrastructureException;
import co.com.bck.commons.responses.ResponseArqB;
import co.com.bck.infrastructure.config.MicroserviceConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;
@Slf4j
@Component
public class MicroserviceClient {
    private final RestTemplate restTemplate;
    private final MicroserviceConfig configLoader;
    private static final String LOG_QUERY_TIME = "La consulta tom\u00F3 {}  milisegundos.";

    public MicroserviceClient(MicroserviceConfig configLoader) {
        this.configLoader = configLoader;
        this.restTemplate = new RestTemplate();
    }

    /**
     * Sends a GET request to a specified microservice endpoint and returns the response.
     *
     * @param microserviceName The name of the microservice to send the request to.
     * @param url The specific endpoint URL for the request.
     * @param queryParams A map of query parameters to be added to the URL.
     * @param <T> The type of the response body.
     * @return A ResponseArqB object containing the response from the microservice.
     */
    public <T> ResponseArqB<T> sendGetRequestArqB(String microserviceName, String url, Map<String, String> queryParams) {
        String microserviceUrl = resolveMicroserviceUrl(microserviceName, url);
        microserviceUrl = addQueryParams(microserviceUrl, queryParams);
        log.info("url get: {}", microserviceUrl);
        long startTime = System.currentTimeMillis();
        ResponseEntity<ResponseArqB<T>> responseEntity = restTemplate.exchange(
                microserviceUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ResponseArqB<T>>() {}
        );
        log.info("Raw response: {}", responseEntity.getBody());
        long endTime = System.currentTimeMillis();
        log.info(LOG_QUERY_TIME, endTime - startTime);

        return Objects.requireNonNull(responseEntity.getBody());
    }

    /**
     * Resolves the full URL for a microservice endpoint.
     *
     * @param microserviceName The name of the microservice.
     * @param url The specific endpoint URL.
     * @return The full URL for the microservice endpoint.
     * @throws InfrastructureException If the microservice configuration is not found.
     */
    private String resolveMicroserviceUrl(String microserviceName, String url) {
        String baseUrl = configLoader.getMicroservice().get(microserviceName);
        if (baseUrl == null) {
            throw new InfrastructureException("No se encontró la configuración para el microservicio: " + microserviceName);
        }
        return baseUrl + url;
    }

    /**
     * Adds query parameters to a URL.
     *
     * @param url The base URL to which query parameters will be added.
     * @param queryParams A map of query parameters to add to the URL.
     * @return The URL with added query parameters.
     */
    private String addQueryParams(String url, Map<String, String> queryParams) {
        if (queryParams != null && !queryParams.isEmpty()) {
            StringBuilder queryString = new StringBuilder("?");
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                if (entry.getValue() != null) {
                    queryString.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
                }
            }
            return url + queryString.substring(0, queryString.length() - 1); // Eliminar el último '&'
        }
        return url;
    }
}
