package io.github.shuoros.badgify.util.convrter;

import io.github.shuoros.badgify.domain.enumeration.SocialBadge;
import io.github.shuoros.badgify.domain.model.color.AbstractColor;
import io.github.shuoros.badgify.service.badge.ColorResolverService;
import java.util.Locale;
import javax.annotation.Resource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class RequestParamStringToSocialBadgeConverter implements Converter<String, SocialBadge> {

    @Override
    public SocialBadge convert(String source) {
        return SocialBadge.valueOf(source.toUpperCase(Locale.ROOT));
    }
}
