package io.github.shuoros.badgify.domain.model.color;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
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
