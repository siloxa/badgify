package io.github.shuoros.badgify.service.badge;

import io.github.shuoros.badgify.domain.model.icon.AbstractIcon;
import io.github.shuoros.badgify.domain.model.icon.FlagIcon;
import io.github.shuoros.badgify.domain.model.icon.FontAwesomeIcon;
import io.github.shuoros.badgify.service.badge.errors.InvalidIconException;
import org.springframework.stereotype.Service;

@Service
public class IconResolverService {

    public AbstractIcon resolve(String iconName) {
        if (hasNotADot(iconName)) return FontAwesomeIcon.builder().name(iconName).build(); else if (hasFlagType(iconName)) return FlagIcon
            .builder()
            .name(iconName)
            .build();

        throw new InvalidIconException();
    }

    private static boolean hasFlagType(String iconName) {
        return "flag".equals(iconName.split("\\.")[0]);
    }

    private static boolean hasNotADot(String iconName) {
        return iconName.split("\\.").length < 2;
    }
}
