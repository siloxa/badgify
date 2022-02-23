package solutions.thex.reporeporter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class RepoReporterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepoReporterApplication.class, args);
    }

    @PostConstruct
    public void init(){
        // Setting Spring Boot SetTimeZone
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
    }

}
