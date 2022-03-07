package solutions.thex.badgify.util;

import lombok.Builder;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Builder
public class Regex {

    private String pattern;

    public Stream<MatchResult> matches(final String str) {
        // Compile regular expression
        final Pattern pattern = Pattern.compile(this.pattern);
        // Match regex against str
        final Matcher matcher = pattern.matcher(str);
        // Use results...
        return matcher.results();
    }

}
