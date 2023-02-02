package io.github.shuoros.badgify.util.jackson;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.shuoros.badgify.domain.model.icon.AbstractIcon;
import io.github.shuoros.badgify.domain.model.icon.FlagIcon;
import io.github.shuoros.badgify.domain.model.icon.FontAwesomeIcon;
import java.io.IOException;

public class ToIconDeserializer extends JsonDeserializer<AbstractIcon> {

    private static final String BASE64_REGEX = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$";

    @Override
    public AbstractIcon deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException, JacksonException {
        final JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        if (isBase64(node.get("content").asText())) {
            return FlagIcon.builder().name(node.get("name").asText()).build();
        }
        return FontAwesomeIcon.builder().name(node.get("name").asText()).build();
    }

    private static boolean isBase64(String icon) {
        return icon.matches(BASE64_REGEX);
    }
}
