package solutions.thex.badgify.svg;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import solutions.thex.badgify.soy.ISoyConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * Implements {@link solutions.thex.badgify.soy.ISoyConfiguration}  to provide and abstract interface for
 * different type of SVGs.Each derivative type must implement getTemplatePath() for .soy template file and
 * getParameters() for the template parameters. For example see
 * {@link solutions.thex.badgify.svg.generator.badge.LTRLinkGenerator}.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public abstract class SvgGenerator implements ISoyConfiguration {

    public abstract String getTemplatePath();

    @Override
    public String getName() {
        return "solutions.thex.badgify.svg";
    }

    @Override
    public File getFile() throws IOException {
        File tempFile = File.createTempFile(//
                "template.svg",//
                ".soy");
        tempFile.deleteOnExit();

        loadTemplateIn(tempFile);

        return tempFile;
    }

    private void loadTemplateIn(File tempFile) throws IOException {
        FileUtils.copyInputStreamToFile(//
                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(getTemplatePath())),//
                tempFile);
    }

}
