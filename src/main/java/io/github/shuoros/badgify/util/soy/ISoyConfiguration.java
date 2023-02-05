package io.github.shuoros.badgify.util.soy;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface ISoyConfiguration {
    /**
     * @return soy fully-qualified name
     */
    String getName();

    /**
     * @return map of soy parameters
     */
    Map<String, String> getParameters();

    /**
     * @return template file path
     * @throws IOException throws IOException
     */
    File getFile() throws IOException;

    default String render() throws IOException {
        return SoyTemplateGenerator.render(this);
    }
}
