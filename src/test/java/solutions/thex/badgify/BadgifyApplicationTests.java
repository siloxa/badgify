package solutions.thex.badgify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import solutions.thex.badgify.controller.badge.BadgeController;
import solutions.thex.badgify.controller.badge.InlineBadgeController;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BadgifyApplicationTests {

    @Autowired
    private BadgifyApplication application;

    @Autowired
    private BadgeController badgeController;

    @Autowired
    private InlineBadgeController inlineBadgeController;

    @Test
    void contextLoads() {
        assertNotNull(application);
    }

    @Test
    void badgeControllerLoads() {
        assertNotNull(badgeController);
    }

    @Test
    void inlineBadgeControllerLoads() {
        assertNotNull(inlineBadgeController);
    }

}
