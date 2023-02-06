package io.github.shuoros.badgify.service.badge;

import io.github.shuoros.badgify.domain.Badge;
import io.github.shuoros.badgify.domain.enumeration.BadgeType;
import io.github.shuoros.badgify.domain.enumeration.CounterBadgeType;
import io.github.shuoros.badgify.domain.enumeration.SocialBadge;
import io.github.shuoros.badgify.domain.model.badge.AbstractBadge;
import io.github.shuoros.badgify.domain.model.badge.CounterBadge;
import io.github.shuoros.badgify.domain.model.badge.IconBadge;
import io.github.shuoros.badgify.domain.model.badge.LabelBadge;
import io.github.shuoros.badgify.repository.BadgeRepository;
import java.io.IOException;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BadgeService {

    @Resource
    private BadgeRepository badgeRepository;

    public String generateBadge(AbstractBadge badge) throws IOException {
        return badge.render();
    }

    public String generatePersistedBadge(UUID id) throws IOException {
        final Badge badge = badgeRepository.findById(id).orElseThrow();
        countOne(badge);
        if (badge.getBadge() instanceof CounterBadge) updateCountedText((CounterBadge) badge.getBadge(), badge);
        badgeRepository.save(badge);
        return generateBadge(badge.getBadge());
    }

    public String generateCounterBadge(CounterBadge counterBadge) throws IOException {
        final Badge badge = badgeRepository
            .findByBadge_id(counterBadge.getId())
            .orElseGet(() -> new Badge().badge(counterBadge).badgeType(BadgeType.COUNTER).count(0L));
        countOne(badge);
        updateCountedText(counterBadge, badge);
        badgeRepository.save(badge);
        return generateBadge(counterBadge);
    }

    public String generateSocialBadge(LabelBadge labelBadge) throws IOException {
        labelBadge.getIcon().resolve(labelBadge.getFontColor());
        return generateBadge(labelBadge);
    }

    private static void countOne(Badge badge) {
        badge.setCount(badge.getCount() + 1);
    }

    private static void updateCountedText(CounterBadge counterBadge, Badge badge) {
        counterBadge.setText(buildText(counterBadge, badge.getCount()));
    }

    private static String buildText(CounterBadge counterBadge, Long count) {
        if (counterBadge.getText().isEmpty() && counterBadge.getType() == CounterBadgeType.PROFILE) {
            return counterBadge.getId() + "'s Profile View: " + count;
        } else if (counterBadge.getText().isEmpty() && counterBadge.getType() == CounterBadgeType.REPOSITORY) {
            return counterBadge.getId() + "'s Repository View: " + count;
        }
        return counterBadge.getText().replace(" " + (count - 1), "") + " " + count;
    }
}
