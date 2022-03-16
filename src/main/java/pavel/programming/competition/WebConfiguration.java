package pavel.programming.competition;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = {"pavel.programming.competition"})
public class WebConfiguration {

    @Value("${JDoodle.api.httClient.connectTimeout:5000}")
    private int jDoodleHttClientConnectTimeout;

    @Bean
    public RestTemplate getJDoodleRestTemplate() {
        return new RestTemplate(getClientHttpRequestFactory());
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(jDoodleHttClientConnectTimeout);
        return clientHttpRequestFactory;
    }
}
