package io.github.shuoros.badgify.service.badge;

import io.github.shuoros.badgify.domain.model.badge.IconBadge;
import io.github.shuoros.badgify.util.svg.IconSvg;
import io.github.shuoros.badgify.util.svg.IconSvgRenderer;
import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public class IconBadgeGeneratorService {

    public String generate(IconBadge iconBadge) throws IOException {
        return IconSvgRenderer.builder().iconSvg(createLabelSvg(iconBadge)).build().render();
    }

    private IconSvg createLabelSvg(IconBadge iconBadge) {
        return IconSvg.builder().iconBadge(iconBadge).build().calculateSvgParams();
    }
}
