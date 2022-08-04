package solutions.thex.badgify.wrapper.badge.inline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import solutions.thex.badgify.svg.wrapper.badge.inline.InlineLinkAsResponseWrapper;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class InlineLinkAsResponseWrapperTests {

    private InlineLinkAsResponseWrapper inlineLinkAsResponseWrapper;

    @BeforeEach
    void setup(@Autowired InlineLinkAsResponseWrapper inlineLinkAsResponseWrapper) {
        this.inlineLinkAsResponseWrapper = inlineLinkAsResponseWrapper;
    }

    @Test
    void wrapMustReturnUnprocessableEntityHttpStatusAsResponseEntityWhenAnyOfParamsNotProvided() throws IOException {
        // Given
        // missing icon param for example
        String design = "ltr_s_simple_badgify_black_white_#";

        // Act & Assert
        assertThrows(solutions.thex.badgify.exception.NotSatisfiedParametersException.class,//
                () -> inlineLinkAsResponseWrapper.wrap(design));
    }

    @Test
    void wrapMustReturnOkHttpStatusAsResponseEntityWhenAllParamsProvidedWithWhiteSpaceSplitter() throws IOException {
        // Given
        String design = "ltr s simple badgify github black white #";

        // When
        var response = inlineLinkAsResponseWrapper.wrap(design);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void wrapMustReturnOkHttpStatusAsResponseEntityWhenAllParamsProvidedWithUnderLineSplitter() throws IOException {
        // Given
        String design = "ltr_s_simple_badgify_github_black_white_#";

        // When
        var response = inlineLinkAsResponseWrapper.wrap(design);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void wrapMustReturnOkHttpStatusAsResponseEntityWhenAllParamsProvidedWithHyphenSplitter() throws IOException {
        // Given
        String design = "ltr-s-simple-repo_reporter-github-black-white-#";

        // When
        var response = inlineLinkAsResponseWrapper.wrap(design);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void shortWrapMustReturnUnprocessableEntityHttpStatusAsResponseEntityWhenAnyOfRequiredParamsNotProvided() throws IOException {
        // Given
        // missing icon param for example
        String design = "badgify_black_white";

        // Act & Assert
        assertThrows(solutions.thex.badgify.exception.NotSatisfiedParametersException.class,//
                () -> inlineLinkAsResponseWrapper.wrap(design));
    }

    @Test
    void shortWrapMustReturnOkHttpStatusAsResponseEntityWhenAllParamsProvidedWithWhiteSpaceSplitter() throws IOException {
        // Given
        String design = "badgify github black s";

        // When
        var response = inlineLinkAsResponseWrapper.wrapShort(design);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void shortWrapMustReturnOkHttpStatusAsResponseEntityWhenAllParamsProvidedWithUnderLineSplitter() throws IOException {
        // Given
        String design = "badgify_github_black_s";

        // When
        var response = inlineLinkAsResponseWrapper.wrapShort(design);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void shortWrapMustReturnOkHttpStatusAsResponseEntityWhenAllParamsProvidedWithHyphenSplitter() throws IOException {
        // Given
        String design = "repo_reporter-github-black-s";

        // When
        var response = inlineLinkAsResponseWrapper.wrapShort(design);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
