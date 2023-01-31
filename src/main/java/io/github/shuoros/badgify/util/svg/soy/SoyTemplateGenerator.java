package io.github.shuoros.badgify.util.svg.soy;

import com.google.template.soy.jbcsrc.api.SoySauce.Renderer;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringEscapeUtils;

/**
 * This class generates a file from a Soy template which is the Java
 * implementation of Closure Templates from Google. See
 * <a href="https://github.com/google/closure-templates">Closure templates
 * repository</a>
 */
@Slf4j
public class SoyTemplateGenerator {

    public static String render(ISoyConfiguration configuration) throws IOException {
        log.debug("Render soy template: {}", configuration.getFile().getAbsolutePath());
        final Renderer renderer = getRenderer(configuration.getFile().getAbsolutePath(), configuration.getName());

        final Map<String, Object> data = new HashMap<>();
        data.putAll(configuration.getParameters());
        data.putAll(getCommonData(configuration));
        renderer.setData(data);
        return StringEscapeUtils.unescapeHtml4(renderer.renderText().get());
    }

    /**
     * Creates and return a {@link Renderer} using the templateURL provided
     *
     * @return created {@link Renderer}
     * @throws FileNotFoundException if the template file is not found.
     */
    private static Renderer getRenderer(String path, String name) throws FileNotFoundException {
        final SoyCompiler compiler = new SoyCompiler();
        final String[] args = { "--srcs", path };
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (compiler.run(args, new PrintStream(byteArrayOutputStream, true)) == 0) {
            return compiler.getSoySauce().renderTemplate(name);
        } else {
            log.error(byteArrayOutputStream.toString());
            throw new FileNotFoundException(path);
        }
    }

    private static Map<String, Object> getCommonData(ISoyConfiguration configuration) throws IOException {
        return Map.of("source", getFilename(configuration) + " - " + configuration.getName());
    }

    private static String getFilename(ISoyConfiguration configuration) throws IOException {
        final String file = configuration.getFile().getAbsolutePath();
        return file.substring(0, file.lastIndexOf('.'));
    }
}
