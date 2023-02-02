package io.github.shuoros.badgify.service.badge;

import io.github.shuoros.badgify.domain.Badge;
import io.github.shuoros.badgify.domain.enumeration.BadgeType;
import io.github.shuoros.badgify.domain.enumeration.CounterBadgeType;
import io.github.shuoros.badgify.domain.model.badge.CounterBadge;
import io.github.shuoros.badgify.domain.model.badge.LabelBadge;
import io.github.shuoros.badgify.domain.model.badge.TextBadge;
import io.github.shuoros.badgify.repository.BadgeRepository;
import io.github.shuoros.badgify.util.svg.LabelSvg;
import io.github.shuoros.badgify.util.svg.LabelSvgRenderer;
import io.github.shuoros.badgify.util.svg.TextSvg;
import io.github.shuoros.badgify.util.svg.TextSvgRenderer;
import java.io.IOException;
import javax.annotation.Resource;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.stereotype.Service;

@Service
public class CounterBadgeGeneratorService {

    @Resource
    private BadgeRepository badgeRepository;

    public String generate(CounterBadge counterBadge) throws IOException {
        final Badge badge = badgeRepository
            .findByBadge_id(counterBadge.getId())
            .orElseGet(() -> new Badge().badge(counterBadge).badgeType(BadgeType.COUNTER).count(0L));
        if (!counterBadge.getDoNotCount()) badge.setCount(badge.getCount() + 1);
        saveCounterBadgeInBadge(counterBadge, badge);
        return (counterBadge.getNoIcon())
            ? generateTextBadge(counterBadge, badge.getCount())
            : generateLabelBadge(counterBadge, badge.getCount());
    }

    private void saveCounterBadgeInBadge(CounterBadge counterBadge, Badge badge) {
        final CounterBadge badgeToSave = SerializationUtils.clone(counterBadge);
        badgeToSave.getIcon().setContent(null);
        badge.setBadge(badgeToSave);
        badgeRepository.save(badge);
    }

    private String generateTextBadge(CounterBadge counterBadge, Long count) throws IOException {
        return TextSvgRenderer.builder().svg(createTextSvg(counterBadge, count)).build().render();
    }

    private TextSvg createTextSvg(CounterBadge counterBadge, Long count) {
        return TextSvg.builder().badge(createTextBadge(counterBadge, count)).build().calculateSvgParams();
    }

    private TextBadge createTextBadge(CounterBadge counterBadge, Long count) {
        return TextBadge
            .builder()
            .text(buildText(counterBadge, count))
            .theme(counterBadge.getTheme())
            .size(counterBadge.getSize())
            .backgroundColor(counterBadge.getBackgroundColor())
            .fontColor(counterBadge.getFontColor())
            .link(counterBadge.getLink())
            .build();
    }

    private String generateLabelBadge(CounterBadge counterBadge, Long count) throws IOException {
        return LabelSvgRenderer.builder().svg(createLabelSvg(counterBadge, count)).build().render();
    }

    private LabelSvg createLabelSvg(CounterBadge counterBadge, Long count) {
        return LabelSvg.builder().badge(createLabelBadge(counterBadge, count)).build().calculateSvgParams();
    }

    private LabelBadge createLabelBadge(CounterBadge counterBadge, Long count) {
        return LabelBadge
            .builder()
            .text(buildText(counterBadge, count))
            .icon(counterBadge.getIcon())
            .theme(counterBadge.getTheme())
            .size(counterBadge.getSize())
            .backgroundColor(counterBadge.getBackgroundColor())
            .fontColor(counterBadge.getFontColor())
            .link(counterBadge.getLink())
            .build();
    }

    private String buildText(CounterBadge counterBadge, Long count) {
        if (counterBadge.getText().isEmpty() && counterBadge.getType() == CounterBadgeType.PROFILE) {
            return counterBadge.getId() + "'s Profile View: " + count;
        } else if (counterBadge.getText().isEmpty() && counterBadge.getType() == CounterBadgeType.REPOSITORY) {
            return counterBadge.getId() + "'s Repository View: " + count;
        }
        return counterBadge.getText() + " " + count;
    }
}
