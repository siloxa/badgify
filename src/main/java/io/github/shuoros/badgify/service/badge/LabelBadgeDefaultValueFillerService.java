package io.github.shuoros.badgify.service.badge;

import io.github.shuoros.badgify.domain.enumeration.Size;
import io.github.shuoros.badgify.domain.enumeration.Theme;
import io.github.shuoros.badgify.domain.model.badge.LabelBadge;
import io.github.shuoros.badgify.domain.model.color.HexColor;
import org.springframework.stereotype.Service;

@Service
public class LabelBadgeDefaultValueFillerService extends AbstractBadgeDefaultValueFillerService<LabelBadge> {

    @Override
    protected LabelBadge defaultBadge() {
        return LabelBadge
            .builder()
            .text("Badgify")
            .icon("github")
            .theme(Theme.SIMPLE)
            .size(Size.S)
            .backgroundColor(HexColor.builder().value("000").build())
            .fontColor(HexColor.builder().value("FFF").build())
            .link("https://github.com/shuoros")
            .build();
    }
}
