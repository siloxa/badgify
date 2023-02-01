package io.github.shuoros.badgify.service.badge;

import io.github.shuoros.badgify.domain.model.badge.TextBadge;
import io.github.shuoros.badgify.util.svg.TextSvg;
import io.github.shuoros.badgify.util.svg.TextSvgRenderer;
import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public class TextBadgeGeneratorService {

    public String generate(TextBadge labelBadge) throws IOException {
        return TextSvgRenderer.builder().svg(createLabelSvg(labelBadge)).build().render();
    }

    private TextSvg createLabelSvg(TextBadge textBadge) {
        return TextSvg.builder().badge(textBadge).build().calculateSvgParams();
    }
}
