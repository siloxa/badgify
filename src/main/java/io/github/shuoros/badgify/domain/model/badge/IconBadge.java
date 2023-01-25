package io.github.shuoros.badgify.domain.model.badge;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IconBadge extends AbstractBadge {

    private String icon;
}
