package io.github.shuoros.badgify.web.controller;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BadgeControllerTestsArgumentProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
            Arguments.of(
                "label",
                status().isOk(),
                new LinkedMultiValueMap<String, String>(),
                readBadge("1")
            )
        );
    }

    private static String readBadge(String badge) {
        try {
            final File svgFile = ResourceUtils.getFile("classpath:testdata/" + badge + ".svg");
            return FileUtils.readFileToString(svgFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
