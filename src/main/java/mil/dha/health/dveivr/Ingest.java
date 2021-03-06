package mil.dha.health.dveivr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Application main
 */
@SpringBootApplication
public class Ingest {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Ingest.class, args);
        PatientIngest encountersIngest = (PatientIngest)ctx.getBean("patientIngest");

        encountersIngest.run();
    }
}