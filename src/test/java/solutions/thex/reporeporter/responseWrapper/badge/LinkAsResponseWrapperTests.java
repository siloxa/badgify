package solutions.thex.reporeporter.responseWrapper.badge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import solutions.thex.reporeporter.svg.responseWrapper.badge.LinkAsResponseWrapper;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class LinkAsResponseWrapperTests {

    private LinkAsResponseWrapper linkAsResponseWrapper;

    @BeforeEach
    void setup() {
        linkAsResponseWrapper = new LinkAsResponseWrapper();
    }

    @Test
    void wrapMustReturnUnprocessableEntityHttpStatusAsResponseEntityWhenTitleNotProvided() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "title", "-1",
                "logo", "github",//
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
    void wrapMustReturnUnprocessableEntityHttpStatusAsResponseEntityWhenLogoNotProvided() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "title", "repo-reporter",
                "logo", "-1",//
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
    void wrapMustReturnOKHttpStatusAsResponseEntityWhenBothLogoAndTitleProvided() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "title", "repo-reporter",
                "logo", "github",//
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
