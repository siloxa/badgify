package io.github.shuoros.badgify.service.badge;

import io.github.shuoros.badgify.domain.model.badge.AbstractBadge;

public abstract class AbstractBadgeDefaultValueFillerService<B extends AbstractBadge> {

    public void fillInDefaultValues(B badge) {
        badge.fillByDefaultValues(defaultBadge());
    }

    protected abstract B defaultBadge();
}
