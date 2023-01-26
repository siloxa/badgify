package io.github.shuoros.badgify.domain.model.color;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RgbColor implements Color {

    private Integer r;

    private Integer g;

    private Integer b;

    @Override
    public String toString() {
        return "rgb(" + getR() + ", " + getG() + ", " + getB() + ")";
    }
}
