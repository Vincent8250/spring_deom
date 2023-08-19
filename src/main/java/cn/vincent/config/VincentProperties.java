package cn.vincent.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "vincent")
public class VincentProperties {
    String id;
    String name;
    String msg;
}
