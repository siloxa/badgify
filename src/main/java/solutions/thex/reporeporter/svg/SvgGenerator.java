package solutions.thex.reporeporter.svg;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import solutions.thex.reporeporter.soy.ISoyConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Component
public abstract class SvgGenerator implements ISoyConfiguration {

    public abstract String getTemplatePath();

    @Override
    public String getName() {
        return "solutions.thex.reporeporter.svg";
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
