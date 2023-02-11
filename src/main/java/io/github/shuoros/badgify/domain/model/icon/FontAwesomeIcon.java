package io.github.shuoros.badgify.domain.model.icon;

import io.github.shuoros.badgify.domain.model.color.AbstractColor;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.core.io.ClassPathResource;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FontAwesomeIcon extends AbstractIcon {

    private static final String FONT_AWESOME_ICONS_PATH = "static/icons/font-awesome/";
    public static final List<String> ICONS;

    static {
        try {
            ICONS =
                Arrays
                    .stream(Objects.requireNonNull(new ClassPathResource(FONT_AWESOME_ICONS_PATH).getFile().list()))
                    .map(icon -> icon.replace(SVG_EXTENSION, ""))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void resolve(AbstractColor color) throws IOException {
        String content = super.retrieveIconFile(FONT_AWESOME_ICONS_PATH + super.getName().toLowerCase(Locale.ROOT));
        content = super.fillColor(content, color);
        content = super.replaceScapeChars(content);
        super.setContent(DATA_IMAGE_SVG_XML_UTF_8 + content);
    }

    @Override
    public String toString() {
        return super.getContent();
    }
}
