package za.ac.cput.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * @Author Curstin Rose - 220275408
 * WebConfigProperties.java
 * 2022/10/15
 */
@ConfigurationProperties(prefix = "web")
@ConstructorBinding
public class WebConfigProperties {
    private final Cors cors;

    public WebConfigProperties(Cors cors) {
        this.cors = cors;
    }

    public Cors getCors() {
        return cors;
    }

    public record Cors(String[] allowedOrigins, String[] allowedMethods) {
    }
}
