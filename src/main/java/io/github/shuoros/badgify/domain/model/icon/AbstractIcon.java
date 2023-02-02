package io.github.shuoros.badgify.domain.model.icon;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.shuoros.badgify.util.jackson.ToIconDeserializer;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonDeserialize(using = ToIconDeserializer.class)
public abstract class AbstractIcon implements IconFileResolver, Serializable {

    private String name;

    private String content;
}
