package io.github.shuoros.badgify.domain.model.icon;

import io.github.shuoros.badgify.domain.model.color.AbstractColor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FontAwesomeIcon extends AbstractIcon {

    private static final String FONT_AWESOME = "font-awesome/";

    @Override
    public void resolve(AbstractColor color) {
        String content = super.retrieveIconFile(FONT_AWESOME + super.getName());
        content = super.fillColor(content, color);
        content = super.replaceScapeChars(content);
        super.setContent(DATA_IMAGE_SVG_XML_UTF_8 + content);
    }

    @Override
    public String toString() {
        return super.getContent();
    }
}
