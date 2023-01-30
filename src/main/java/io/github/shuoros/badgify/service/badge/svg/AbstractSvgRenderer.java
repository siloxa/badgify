package io.github.shuoros.badgify.service.badge.svg;

import io.github.shuoros.badgify.domain.model.badge.AbstractBadge;
import io.github.shuoros.badgify.service.badge.svg.soy.ISoyConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import org.apache.commons.io.FileUtils;

/**
 * Implements {@link ISoyConfiguration}  to provide and abstract interface for
 * different type of SVGs. Each derivative type must implement getTemplatePath() for .soy template file and
 * getParameters() for the template parameters. For example see
 * {@link LabelSvgRenderer}.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class AbstractSvgRenderer implements ISoyConfiguration {

    public abstract String getTemplatePath();

    @Override
    public String getName() {
        return "io.github.shuoros.badgify.svg";
    }

    @Override
    public File getFile() throws IOException {
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
