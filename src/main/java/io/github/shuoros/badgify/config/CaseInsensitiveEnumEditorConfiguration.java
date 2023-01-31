package io.github.shuoros.badgify.config;

import io.github.shuoros.badgify.domain.enumeration.Size;
import io.github.shuoros.badgify.domain.enumeration.Theme;
import io.github.shuoros.badgify.util.editor.CaseInsensitiveEnumEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseInsensitiveEnumEditorConfiguration {

    @Bean(name = "theme-enum-editor")
    public CaseInsensitiveEnumEditor getThemeCaseInsensitiveEnumEditor() {
        return new CaseInsensitiveEnumEditor(Theme.class);
    }

    @Bean(name = "size-enum-editor")
    public CaseInsensitiveEnumEditor getSizeCaseInsensitiveEnumEditor() {
        return new CaseInsensitiveEnumEditor(Size.class);
    }
}
