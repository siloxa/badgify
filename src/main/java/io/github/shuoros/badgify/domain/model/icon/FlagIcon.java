package io.github.shuoros.badgify.domain.model.icon;

import io.github.shuoros.badgify.domain.model.color.AbstractColor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class FlagIcon extends AbstractIcon {

    private static final String FLAGS = "flags/";

    @Override
    public void resolve(AbstractColor color) {
        String content = super.retrieveIconFile(FLAGS + super.getName().split("\\.")[1]);
        super.setContent(DATA_IMAGE_SVG_XML_BASE_64 + super.encodeFromStringToBase64(content));
    }

    @Override
    public String toString() {
        return super.getContent();
    }
}
