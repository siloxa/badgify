package solutions.thex.reporeporter.util;

import lombok.Builder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Builder
public class Regex {

    private String pattern;

    public boolean matches(final String str) {
        // Compile regular expression
        final Pattern pattern = Pattern.compile(this.pattern);
        // Match regex against str
        final Matcher matcher = pattern.matcher(str);
        // Use results...
        return matcher.results().count() >= 4;
    }

}
