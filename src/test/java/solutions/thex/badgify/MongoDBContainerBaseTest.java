package solutions.thex.badgify;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.net.URI;

@Testcontainers
@DirtiesContext
public class MongoDBContainerBaseTest {

    @Container
    public static MongoDBContainer mongoDBContainer =//
            new MongoDBContainer("mongo:latest");

    @DynamicPropertySource
    static void applicationProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.host", () -> URI.create(mongoDBContainer.getReplicaSetUrl()).getHost());
        registry.add("spring.data.mongodb.port", () -> URI.create(mongoDBContainer.getReplicaSetUrl()).getPort());
        registry.add("spring.data.mongodb.replica-set-name", () -> "docker-rs");
    }

    static {
        mongoDBContainer.start();
    }

}
