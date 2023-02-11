package io.github.shuoros.badgify.service.badge;

import io.github.shuoros.badgify.domain.model.icon.AbstractIcon;
import io.github.shuoros.badgify.domain.model.icon.FlagIcon;
import io.github.shuoros.badgify.domain.model.icon.FontAwesomeIcon;
import io.github.shuoros.badgify.service.badge.errors.InvalidIconException;
import org.springframework.stereotype.Service;

@Service
public class IconResolverService {

    private static final String SVG_EXTENSION = ".svg";
    private static final String FLAG = "flag";

    public AbstractIcon resolve(String iconName) {
        if (hasNotADot(iconName) && isFontAwesomeIcon(iconName)) {
            return FontAwesomeIcon.builder().name(iconName).build();
        } else if (hasFlagType(iconName) && isFlagIcon(iconName)) {
            return FlagIcon.builder().name(iconName).build();
        }
        throw new InvalidIconException();
    }

    private static boolean isFontAwesomeIcon(String iconName) {
        return FontAwesomeIcon.ICONS.contains(iconName);
    }

    private static boolean isFlagIcon(String iconName) {
        return FlagIcon.ICONS.contains(iconName.split("\\.")[1]);
    }

    private static boolean hasFlagType(String iconName) {
        return FLAG.equals(iconName.split("\\.")[0]);
    }

    private static boolean hasNotADot(String iconName) {
        return iconName.split("\\.").length < 2;
    }
}
