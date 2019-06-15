package ru.springboot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Data
@ConfigurationProperties(prefix = "exam")
public class ExamProperties {
    private Map<String, String> serviceNameToUrl;
}
