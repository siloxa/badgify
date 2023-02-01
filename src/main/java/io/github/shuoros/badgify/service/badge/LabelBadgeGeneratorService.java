package io.github.shuoros.badgify.service.badge;

import io.github.shuoros.badgify.domain.model.badge.LabelBadge;
import io.github.shuoros.badgify.util.svg.LabelSvg;
import io.github.shuoros.badgify.util.svg.LabelSvgRenderer;
import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public class LabelBadgeGeneratorService {

    public String generate(LabelBadge labelBadge) throws IOException {
        return LabelSvgRenderer.builder().svg(createLabelSvg(labelBadge)).build().render();
    }

    private LabelSvg createLabelSvg(LabelBadge labelBadge) {
        return LabelSvg.builder().badge(labelBadge).build().calculateSvgParams();
    }
}
