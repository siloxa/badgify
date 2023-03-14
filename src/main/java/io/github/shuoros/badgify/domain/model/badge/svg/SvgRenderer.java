package io.github.shuoros.badgify.domain.model.badge.svg;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.shuoros.badgify.util.soy.ISoyConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import org.apache.commons.io.FileUtils;

/**
 * Implements {@link ISoyConfiguration}  to provide and abstract interface for
 * different type of SVGs. Each derivative type must implement getTemplatePath() for .soy template file and
 * getParameters() for the template parameters
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
public interface SvgRenderer extends Svg, ISoyConfiguration {
    @JsonIgnore
    String getTemplatePath();

    @Override
    default String getName() {
        return "io.github.shuoros.badgify.svg";
    }

    @Override
    default File getFile() throws IOException {
        File tempFile = File.createTempFile("template.svg", ".soy");
        tempFile.deleteOnExit();

        loadTemplateIn(tempFile);

        return tempFile;
    }

    private void loadTemplateIn(File tempFile) throws IOException {
        FileUtils.copyInputStreamToFile(
            Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(getTemplatePath())),
            tempFile
        );
    }
}
