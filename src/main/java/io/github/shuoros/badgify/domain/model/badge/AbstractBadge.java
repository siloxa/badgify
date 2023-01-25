package io.github.shuoros.badgify.domain.model.badge;

import io.github.shuoros.badgify.domain.enumeration.Size;
import io.github.shuoros.badgify.domain.enumeration.Theme;
import io.github.shuoros.badgify.domain.model.color.Color;
import lombok.Data;

@Data
public abstract class AbstractBadge {

    private Theme theme;

    private Size size;

    private Color backgroundColor;

    private Color fontColor;
}
