package solutions.thex.reporeporter.soy;

import com.google.template.soy.jbcsrc.api.SoySauce.Renderer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringEscapeUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

/**
 * This class generates a file from a Soy template which is the Java
 * implementation of Closure Templates from Google. See
 * <a href="https://github.com/google/closure-templates">Closure templates
 * repository</a>
 */
@AllArgsConstructor
@Slf4j
public class SoyTemplateGenerator {

    Map<String, Object> parameters;

    /**
     * Creates and return a {@link Renderer} using the templateURL provided
     *
     * @return created {@link Renderer}
     * @throws FileNotFoundException
     */
    private static Renderer getRenderer(String path, String name) throws FileNotFoundException {
        SoyCompiler compiler = new SoyCompiler();
        String[] args = {"--srcs", path};
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (compiler.run(args, new PrintStream(byteArrayOutputStream, true)) == 0) {
            return compiler.getSoySauce().renderTemplate(name);
        } else {
            log.error(byteArrayOutputStream.toString());
            throw new FileNotFoundException(path);
        }
    }

    public static void generate(ISoyConfiguration configuration) throws IOException {
        String generatedContent = render(configuration);
        if (!Files.exists(configuration.getPath().getParent())) {
            Files.createDirectories(configuration.getPath().getParent());
        }
        try (Writer writer = Files.newBufferedWriter(configuration.getPath())) {
            writer.write(generatedContent);
        }
    }

    public static String render(ISoyConfiguration configuration) throws IOException {
        log.debug("-- {}", configuration.getFile().getAbsolutePath());
        Renderer renderer = getRenderer(configuration.getFile().getAbsolutePath(), configuration.getName());

        Map<String, Object> data = new HashMap<>();
        data.putAll(configuration.getParameters());
        data.putAll(getCommonData(configuration));
        renderer.setData(data);
        return StringEscapeUtils.unescapeHtml4(renderer.renderText().get());
    }

    private static Map<String, Object> getCommonData(ISoyConfiguration configuration) throws IOException {
        return Map.of("source", getFilename(configuration) + " - " + configuration.getName());
    }

    private static String getFilename(ISoyConfiguration configuration) throws IOException {
        String file = configuration.getFile().getAbsolutePath();
        file = file.substring(0, file.lastIndexOf('.'));
        return file;
    }

}

