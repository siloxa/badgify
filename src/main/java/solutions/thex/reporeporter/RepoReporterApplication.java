package solutions.thex.reporeporter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * RepoReporterApplication.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @see https://github.com/TheXSolutions/repo-reporter
 * @see https://repo-reporter.thex.solurions
 * @since 1.0.0
 */
@SpringBootApplication
public class RepoReporterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepoReporterApplication.class, args);
    }

    /**
     * This function executes after the application is started.
     */
    @PostConstruct
    public void init() {
        // Setting Spring Boot SetTimeZone
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
    }

}
