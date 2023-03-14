package io.github.shuoros.badgify.util.convrter;

import io.github.shuoros.badgify.domain.enumeration.SocialBadge;
import java.util.Locale;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RequestParamStringToSocialBadgeConverter implements Converter<String, SocialBadge> {

    @Override
    public SocialBadge convert(String source) {
        return SocialBadge.valueOf(source.toUpperCase(Locale.ROOT));
    }
}
