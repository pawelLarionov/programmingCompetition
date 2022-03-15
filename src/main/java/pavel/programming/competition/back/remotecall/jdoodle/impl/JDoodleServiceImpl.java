package pavel.programming.competition.back.remotecall.jdoodle.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pavel.programming.competition.back.remotecall.jdoodle.JDoodleService;
import pavel.programming.competition.back.remotecall.jdoodle.model.JDoodleRequest;
import pavel.programming.competition.back.remotecall.jdoodle.model.JDoodleResponse;

@Service
public class JDoodleServiceImpl implements JDoodleService {
    private static final Logger logger = LoggerFactory.getLogger(JDoodleServiceImpl.class);

    @Value("${JDoodle.api.url}")
    private String jDoodleApiUrl;

    @Value("${JDoodle.api.client.id}")
    private String clientId;

    @Value("${JDoodle.api.client.secret}")
    private String clientSecret;

    @Value("${JDoodle.api.script.language.name}")
    private String scriptLanguage;

    @Value("${JDoodle.api.script.language.version}")
    private String scriptLanguageVersion;

    private final RestTemplate jDoodleRestTemplate;

    public JDoodleServiceImpl(RestTemplate jDoodleRestTemplate) {
        this.jDoodleRestTemplate = jDoodleRestTemplate;
    }

    @Override
    public String executeJava(String solutionCode, String inputParameter) {
        JDoodleRequest jDoodleRequest = new JDoodleRequest(
                clientId, clientSecret, solutionCode, inputParameter, scriptLanguage, scriptLanguageVersion);

        HttpEntity<JDoodleRequest> request = new HttpEntity<>(jDoodleRequest);
        logger.debug("JDoodleRequest: {}", request.toString());

        ResponseEntity<JDoodleResponse> response = null;
        try {
            response = jDoodleRestTemplate.exchange(jDoodleApiUrl, HttpMethod.POST, request, JDoodleResponse.class);
            logger.debug("response: {}", response);
        } catch (RestClientException e) {
            logger.error("Exception on JDoodle call request", e);
        }

        JDoodleResponse jDoodleResponse = getJDoodleResponse(response);
        if (jDoodleResponse == null) {
            return null;
        }

        logger.debug("jDoodleResponse: {}", jDoodleResponse);
        return jDoodleResponse.getOutput();
    }

    private JDoodleResponse getJDoodleResponse(ResponseEntity<JDoodleResponse> response) {
        if (response == null || response.getStatusCode() != HttpStatus.OK) {
            logger.error("JDoodle response.status != 200 response: {}", response);
            return null;
        }

        if (response.getBody() == null) {
            logger.error("JDoodle response.getBody() is null, response: {}", response);
            return null;
        }

        JDoodleResponse jDoodleResponse = response.getBody();
        if (jDoodleResponse.getStatusCode() != 200 || jDoodleResponse.getError() != null) {
            logger.error("JDoodle jDoodleResponse has status: {} error: {} response: {}", jDoodleResponse.getStatusCode(), jDoodleResponse.getError(), response);
            return null;
        }

        return jDoodleResponse;
    }
}
