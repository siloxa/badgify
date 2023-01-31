package io.github.shuoros.badgify.service.badge;

import io.github.shuoros.badgify.domain.model.badge.LabelBadge;
import io.github.shuoros.badgify.service.badge.svg.LabelSvg;
import io.github.shuoros.badgify.service.badge.svg.LabelSvgRenderer;
import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public class LabelBadgeGeneratorService {

    public String generate(LabelBadge labelBadge) throws IOException {
        return LabelSvgRenderer.builder().labelSvg(createLabelSvg(labelBadge)).build().render();
    }

    private LabelSvg createLabelSvg(LabelBadge labelBadge) {
        return LabelSvg.builder().labelBadge(labelBadge).build().calculateSvgParams();
    }
}
