package solutions.thex.badgify.wrapper.badge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import solutions.thex.badgify.svg.wrapper.badge.LinkAsResponseWrapper;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class LinkAsResponseWrapperTests {

    private LinkAsResponseWrapper linkAsResponseWrapper;

    @BeforeEach
    void setup(@Autowired LinkAsResponseWrapper linkAsResponseWrapper) {
        this.linkAsResponseWrapper = linkAsResponseWrapper;
    }

    @Test
    void wrapMustReturnUnprocessableEntityHttpStatusAsResponseEntityWhenTitleNotProvided() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "title", "-1",
                "icon", "github",//
                "theme", "simple",//
                "direction", "ltr",//
                "size", "s",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        var response = linkAsResponseWrapper.wrap(params);

        // Then
        assertEquals(response.getStatusCode(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Test
    void wrapMustReturnUnprocessableEntityHttpStatusAsResponseEntityWhenIconNotProvided() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "title", "badgify",
                "icon", "-1",//
                "theme", "simple",//
                "direction", "ltr",//
                "size", "s",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        var response = linkAsResponseWrapper.wrap(params);

        // Then
        assertEquals(response.getStatusCode(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Test
    void wrapMustReturnOKHttpStatusAsResponseEntityWhenBothIconAndTitleProvided() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "title", "badgify",
                "icon", "github",//
                "theme", "simple",//
                "direction", "ltr",//
                "size", "s",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        var response = linkAsResponseWrapper.wrap(params);

        // Then
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

}
