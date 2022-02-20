package solutions.thex.reporeporter.soy;

import com.google.template.soy.AbstractSoyCompiler;
import com.google.template.soy.SoyFileSet;
import com.google.template.soy.jbcsrc.api.SoySauce;
import lombok.Getter;

import java.io.IOException;

@Getter
public class SoyCompiler extends AbstractSoyCompiler {

    private SoySauce soySauce;

    public SoyCompiler() {
        //
    }

    @Override
    protected void compile(SoyFileSet.Builder sfsBuilder) throws IOException {
        soySauce = sfsBuilder.build().compileTemplates();
    }

}
