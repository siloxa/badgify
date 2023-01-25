package io.github.shuoros.badgify.domain.model.badge;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TextBadge extends AbstractBadge {

    private String text;
}
