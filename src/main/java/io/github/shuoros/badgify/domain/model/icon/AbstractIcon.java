package io.github.shuoros.badgify.domain.model.icon;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes(
    { @JsonSubTypes.Type(value = FlagIcon.class, name = "flag"), @JsonSubTypes.Type(value = FontAwesomeIcon.class, name = "font-awesome") }
)
public abstract class AbstractIcon implements IconFileResolver, Serializable {

    private String name;

    private String content;
}
