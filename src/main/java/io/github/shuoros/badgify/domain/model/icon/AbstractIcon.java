package io.github.shuoros.badgify.domain.model.icon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractIcon implements IconFileResolver {

    private String name;

    private String content;
}
