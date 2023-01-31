package io.github.shuoros.badgify.service.badge;

import io.github.shuoros.badgify.domain.enumeration.Size;
import io.github.shuoros.badgify.domain.enumeration.Theme;
import io.github.shuoros.badgify.domain.model.badge.LabelBadge;
import io.github.shuoros.badgify.domain.model.color.HexColor;
import io.github.shuoros.badgify.domain.model.icon.FontAwesomeIcon;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LabelBadgeDefaultValueFillerService extends AbstractBadgeDefaultValueFillerService<LabelBadge> {

    @Resource
    private IconResolverService iconResolverService;

    @Override
    protected LabelBadge defaultBadge() {
        return LabelBadge
            .builder()
            .text("Badgify")
            .icon(FontAwesomeIcon.builder().name("github").build())
            .theme(Theme.SIMPLE)
            .size(Size.S)
            .backgroundColor(HexColor.builder().value("000").build())
            .fontColor(HexColor.builder().value("FFF").build())
            .link("https://github.com/shuoros")
            .build();
    }
}
