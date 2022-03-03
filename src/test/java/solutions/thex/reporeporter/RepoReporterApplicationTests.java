package solutions.thex.reporeporter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import solutions.thex.reporeporter.controller.badge.BadgeController;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RepoReporterApplicationTests {

    @Autowired
    private RepoReporterApplication application;

    @Autowired
    private BadgeController badgeController;

    @Test
    void contextLoads() {
        assertNotNull(application);
    }

    @Test
    void badgeControllerLoads() {
        assertNotNull(badgeController);
    }

}
