package solutions.thex.reporeporter.soy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public interface ISoyConfiguration {

    /**
     * @return soy fully-qualified name
     */
    String getName();

    /**
     * @return template file path
     * @throws FileNotFoundException
     * @throws IOException
     */
    File getFile() throws IOException;

    /**
     * @return map of soy parameters
     */
    Map<String, Object> getParameters();

    default String render() throws IOException {
        return SoyTemplateGenerator.render(this);
    }
}