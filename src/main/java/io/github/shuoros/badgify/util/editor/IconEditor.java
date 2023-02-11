package io.github.shuoros.badgify.util.editor;

import io.github.shuoros.badgify.service.badge.IconResolverService;
import java.beans.PropertyEditorSupport;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class IconEditor extends PropertyEditorSupport {

    @Resource
    private IconResolverService iconResolverService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(iconResolverService.resolve(text));
    }
}
