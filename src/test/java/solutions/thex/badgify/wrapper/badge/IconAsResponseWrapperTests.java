package solutions.thex.badgify.wrapper.badge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import solutions.thex.badgify.svg.wrapper.badge.IconAsResponseWrapper;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class IconAsResponseWrapperTests {

    private IconAsResponseWrapper iconAsResponseWrapper;

    @BeforeEach
    void setup(@Autowired IconAsResponseWrapper iconAsResponseWrapper) {
        this.iconAsResponseWrapper = iconAsResponseWrapper;
    }

    @Test
    void wrapMustReturnUnprocessableEntityHttpStatusAsResponseEntityWhenIconNotProvided() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "icon", "-1",//
                "theme", "simple",//
                "size", "s",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // Act & Assert
        assertThrows(solutions.thex.badgify.exception.NotSatisfiedParametersException.class,//
                () -> iconAsResponseWrapper.wrap(params));
    }

    @Test
    void wrapMustReturnOKHttpStatusAsResponseEntityWhenIconProvided() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "icon", "github",//
                "theme", "simple",//
                "size", "s",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        var response = iconAsResponseWrapper.wrap(params);

        // Then
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

}
