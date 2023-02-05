package io.github.shuoros.badgify.service.badge;

import io.github.shuoros.badgify.domain.enumeration.Size;
import io.github.shuoros.badgify.domain.enumeration.Theme;
import io.github.shuoros.badgify.domain.model.badge.IconBadge;
import io.github.shuoros.badgify.domain.model.color.HexColor;
import io.github.shuoros.badgify.domain.model.icon.FontAwesomeIcon;
import org.springframework.stereotype.Service;

@Service
public class IconBadgeDefaultValueFillerService extends AbstractBadgeDefaultValueFillerService<IconBadge> {

    @Override
    protected IconBadge defaultBadge() {
        return IconBadge
            .builder()
            .icon(FontAwesomeIcon.builder().name("github").build())
            .theme(Theme.SIMPLE)
            .size(Size.S)
            .backgroundColor(HexColor.builder().value("000").build())
            .fontColor(HexColor.builder().value("FFF").build())
            .link("https://github.com/shuoros")
            .build();
    }
}
