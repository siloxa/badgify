package io.github.shuoros.badgify.domain.model.badge;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LabelBadge extends AbstractBadge {

    private String text;

    private String icon;
}
