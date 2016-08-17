package mil.dha.health.dveivr

import com.marklogic.client.DatabaseClient
import com.marklogic.client.DatabaseClientFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by phoehne on 8/12/16.
 */
@Configuration
public class EncountersConfig {

    @Value('${ml.host}')
    String host

    @Value('${ml.port}')
    int port

    @Value('${ml.username}')
    String username

    @Value('${ml.password}')
    String password

    @Bean
    DatabaseClient databaseClient() {
        DatabaseClient result = DatabaseClientFactory.newClient(host, port, username, password, DatabaseClientFactory.Authentication.DIGEST)
        return result
    }
}
