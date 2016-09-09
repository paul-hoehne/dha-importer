package mil.dha.health.dveivr;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration
 */
@Configuration
public class EncountersConfig {

    @Value("${ml.host}")
    String host;

    @Value("${ml.port}")
    int port;

    @Value("${ml.username}")
    String username;

    @Value("${ml.password}")
    String password;

    @Bean
    DatabaseClient databaseClient() {
        return DatabaseClientFactory.newClient(host, port, username, password, DatabaseClientFactory.Authentication.DIGEST);
    }
}
