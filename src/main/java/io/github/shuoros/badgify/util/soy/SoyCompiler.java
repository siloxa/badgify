package io.github.shuoros.badgify.util.soy;

import com.google.template.soy.AbstractSoyCompiler;
import com.google.template.soy.SoyFileSet;
import com.google.template.soy.jbcsrc.api.SoySauce;
import java.io.IOException;
import lombok.Getter;

@Getter
public class SoyCompiler extends AbstractSoyCompiler {

    private SoySauce soySauce;

    @Override
    protected void compile(SoyFileSet.Builder sfsBuilder) throws IOException {
        soySauce = sfsBuilder.build().compileTemplates();
    }
}
