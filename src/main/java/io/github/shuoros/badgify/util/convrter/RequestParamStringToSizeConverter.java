package io.github.shuoros.badgify.util.convrter;

import io.github.shuoros.badgify.domain.enumeration.Size;
import java.util.Locale;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RequestParamStringToSizeConverter implements Converter<String, Size> {

    @Override
    public Size convert(String source) {
        return Size.valueOf(source.toUpperCase(Locale.ROOT));
    }
}
