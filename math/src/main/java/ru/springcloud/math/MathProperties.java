package ru.springcloud.math;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "math")
public class MathProperties {
    private int max;
}
