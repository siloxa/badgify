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
public class HexColor extends AbstractColor {

    private String value;

    public static HexColor of(String value) {
        return HexColor.builder().value(value).build();
    }

    @Override
    public String toString() {
        String result = getValue().replace("#", "");
        if (result.length() == 3) result = standardize3HexTo6Hex(result);
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
