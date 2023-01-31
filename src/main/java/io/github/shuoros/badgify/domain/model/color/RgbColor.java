package io.github.shuoros.badgify.domain.model.color;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class RgbColor extends AbstractColor {

    private Integer r;

    private Integer g;

    private Integer b;

    @Override
    public String toString() {
        return "rgb(" + getR() + ", " + getG() + ", " + getB() + ")";
    }
}
