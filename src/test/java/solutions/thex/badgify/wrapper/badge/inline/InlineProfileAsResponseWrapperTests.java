package solutions.thex.badgify.wrapper.badge.inline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import solutions.thex.badgify.svg.wrapper.badge.inline.InlineProfileAsResponseWrapper;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class InlineProfileAsResponseWrapperTests {

    private InlineProfileAsResponseWrapper inlineProfileAsResponseWrapper;

    @BeforeEach
    void setup(@Autowired InlineProfileAsResponseWrapper inlineProfileAsResponseWrapper) {
        this.inlineProfileAsResponseWrapper = inlineProfileAsResponseWrapper;
    }

    @Test
    void wrapMustReturnUnprocessableEntityHttpStatusAsResponseEntityWhenAnyOfParamsNotProvided() throws IOException {
        // Given
        // missing id param for example
        String design = "simple_black_white";

        // When
        var response = inlineProfileAsResponseWrapper.wrap(design);

        // Then
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
    }

    @Test
    void wrapMustReturnOkHttpStatusAsResponseEntityWhenAllParamsProvidedWithWhiteSpaceSplitter() throws IOException {
        // Given
        String design = "simple TheXSolutions black white";

        // When
        var response = inlineProfileAsResponseWrapper.wrap(design);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void wrapMustReturnOkHttpStatusAsResponseEntityWhenAllParamsProvidedWithUnderLineSplitter() throws IOException {
        // Given
        String design = "simple_TheXSolutions_black_white";

        // When
        var response = inlineProfileAsResponseWrapper.wrap(design);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void wrapMustReturnOkHttpStatusAsResponseEntityWhenAllParamsProvidedWithHyphenSplitter() throws IOException {
        // Given
        String design = "simple-TheXSolutions-black-white";

        // When
        var response = inlineProfileAsResponseWrapper.wrap(design);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void shortWrapMustReturnUnprocessableEntityHttpStatusAsResponseEntityWhenAnyOfRequiredParamsNotProvided() throws IOException {
        // Given
        // missing id param for example
        String design = "black_white";

        // When
        var response = inlineProfileAsResponseWrapper.wrapShort(design);

        // Then
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
    }

    @Test
    void shortWrapMustReturnOkHttpStatusAsResponseEntityWhenAllParamsProvidedWithWhiteSpaceSplitter() throws IOException {
        // Given
        String design = "TheXSolutions black white";

        // When
        var response = inlineProfileAsResponseWrapper.wrapShort(design);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void shortWrapMustReturnOkHttpStatusAsResponseEntityWhenAllParamsProvidedWithUnderLineSplitter() throws IOException {
        // Given
        String design = "TheXSolutions_black_white";

        // When
        var response = inlineProfileAsResponseWrapper.wrapShort(design);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void shortWrapMustReturnOkHttpStatusAsResponseEntityWhenAllParamsProvidedWithHyphenSplitter() throws IOException {
        // Given
        String design = "TheXSolutions-black-white";

        // When
        var response = inlineProfileAsResponseWrapper.wrapShort(design);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
