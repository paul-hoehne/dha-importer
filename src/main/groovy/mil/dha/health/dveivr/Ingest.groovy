package mil.dha.health.dveivr

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * Created by phoehne on 8/12/16.
 */

@SpringBootApplication
public class Ingest {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Ingest.class, args)
        EncountersIngest encountersIngest = ctx.getBean("encountersIngest")

        encountersIngest.run()
    }
}