package io.github.shuoros.badgify.util.convrter;

import io.github.shuoros.badgify.domain.enumeration.Theme;
import java.util.Locale;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RequestParamStringToThemeConverter implements Converter<String, Theme> {

    @Override
    public Theme convert(String source) {
        return Theme.valueOf(source.toUpperCase(Locale.ROOT));
    }
}
