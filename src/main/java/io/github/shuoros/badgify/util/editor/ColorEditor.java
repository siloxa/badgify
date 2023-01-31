package io.github.shuoros.badgify.util.editor;

import io.github.shuoros.badgify.service.badge.ColorResolverService;
import java.beans.PropertyEditorSupport;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class ColorEditor extends PropertyEditorSupport {

    @Resource
    private ColorResolverService colorResolverService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(colorResolverService.resolve(text));
    }
}
