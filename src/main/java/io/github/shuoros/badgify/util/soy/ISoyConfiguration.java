package io.github.shuoros.badgify.util.soy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface ISoyConfiguration {
    /**
     * @return soy fully-qualified name
     */
    @JsonIgnore
    String getName();

    /**
     * @return map of soy parameters
     */
    @JsonIgnore
    Map<String, String> getParameters();

    /**
     * @return template file path
     * @throws IOException throws IOException
     */
    @JsonIgnore
    File getFile() throws IOException;

    default String render() throws IOException {
        return SoyTemplateGenerator.render(this);
    }
}
