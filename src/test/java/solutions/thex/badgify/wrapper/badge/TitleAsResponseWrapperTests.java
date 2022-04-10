package solutions.thex.badgify.wrapper.badge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import solutions.thex.badgify.svg.wrapper.badge.TitleAsResponseWrapper;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TitleAsResponseWrapperTests {

    private TitleAsResponseWrapper titleAsResponseWrapper;

    @BeforeEach
    void setup(@Autowired TitleAsResponseWrapper titleAsResponseWrapper) {
        this.titleAsResponseWrapper = titleAsResponseWrapper;
    }

    @Test
    void wrapMustReturnUnprocessableEntityHttpStatusAsResponseEntityWhenTitleNotProvided() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "title", "-1",//
                "theme", "simple",//
                "size", "s",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        var response = titleAsResponseWrapper.wrap(params);

        // Then
        assertEquals(response.getStatusCode(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Test
    void wrapMustReturnOKHttpStatusAsResponseEntityWhenTitleProvided() throws IOException {
        // Given
        Map<String, String> params = Map.of(//
                "title", "badgify",//
                "theme", "simple",//
                "size", "s",//
                "link", "#",//
                "bg", "000",//
                "color", "rgb(255, 255, 255)");

        // When
        var response = titleAsResponseWrapper.wrap(params);

        // Then
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

}
