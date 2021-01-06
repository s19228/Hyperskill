package pl.jaknauczycsieprogramowania.schedulling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedullingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedullingApplication.class, args);
    }

}
