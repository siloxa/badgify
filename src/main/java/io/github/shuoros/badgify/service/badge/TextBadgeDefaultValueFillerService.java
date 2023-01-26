package io.github.shuoros.badgify.service.badge;

import io.github.shuoros.badgify.domain.enumeration.Size;
import io.github.shuoros.badgify.domain.enumeration.Theme;
import io.github.shuoros.badgify.domain.model.badge.TextBadge;
import io.github.shuoros.badgify.domain.model.color.HexColor;

public class TextBadgeDefaultValueFillerService extends AbstractBadgeDefaultValueFillerService<TextBadge> {

    @Override
    protected TextBadge defaultBadge() {
        return TextBadge
            .builder()
            .text("Badgify")
            .theme(Theme.SIMPLE)
            .size(Size.S)
            .backgroundColor(HexColor.builder().value("000").build())
            .fontColor(HexColor.builder().value("FFF").build())
            .build();
    }
}
