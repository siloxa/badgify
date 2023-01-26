package io.github.shuoros.badgify.domain.model.color;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HexColor implements Color {

    private String value;

    @Override
    public String toString() {
        if (value.startsWith("#")) return getValue();
        return "#" + getValue();
    }
}
