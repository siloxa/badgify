package solutions.thex.badgify.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import solutions.thex.badgify.log.ControllerLogger;

@Configuration
public class ControllerLoggerConfig {

    @Bean
    public ControllerLogger createLogger(Class<?> clazz) {
        return new ControllerLogger(clazz);
    }

}
