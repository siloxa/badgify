package io.github.shuoros.badgify.domain.model.color;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class HexColor extends AbstractColor {

    private String value;

    @Override
    public String toString() {
        String result = getValue();
        if (result.replace("#", "").length() == 3) result = standardize3HexTo6Hex(result);
        return "#" + result;
    }

    private String standardize3HexTo6Hex(String color) {
        return (
            String.valueOf(color.charAt(0)) +
            String.valueOf(color.charAt(0)) +
            String.valueOf(color.charAt(1)) +
            String.valueOf(color.charAt(1)) +
            String.valueOf(color.charAt(2)) +
            String.valueOf(color.charAt(2))
        );
    }
}
