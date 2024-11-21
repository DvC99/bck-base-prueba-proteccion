package co.com.bck.infrastructure.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
@Getter
@Setter
@ConfigurationProperties("")
public class MicroserviceConfig {
    private Map<String, String> microservice = new HashMap<>();
}
