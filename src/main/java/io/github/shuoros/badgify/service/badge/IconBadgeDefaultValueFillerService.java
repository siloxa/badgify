package io.github.shuoros.badgify.service.badge;

import io.github.shuoros.badgify.domain.enumeration.Size;
import io.github.shuoros.badgify.domain.enumeration.Theme;
import io.github.shuoros.badgify.domain.model.badge.IconBadge;
import io.github.shuoros.badgify.domain.model.color.HexColor;

public class IconBadgeDefaultValueFillerService extends AbstractBadgeDefaultValueFillerService<IconBadge> {

    @Override
    protected IconBadge defaultBadge() {
        return IconBadge
            .builder()
            .icon("github")
            .theme(Theme.SIMPLE)
            .size(Size.S)
            .backgroundColor(HexColor.builder().value("000").build())
            .fontColor(HexColor.builder().value("FFF").build())
            .build();
    }
}
