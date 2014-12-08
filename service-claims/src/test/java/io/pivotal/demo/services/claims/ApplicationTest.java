package io.pivotal.demo.services.claims;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.pivotal.demo.services.common.broker.BrokerConfig;
import io.pivotal.demo.services.common.broker.catalog.CatalogResponse;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, BrokerConfig.class})
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ApplicationTest {

    @Value("${local.server.port}")
    int port;

    String username = "claims";
    String password = "claims";

    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void TestCatalogGoodAuth() {
        ResponseEntity<String> responseEntity =
            restTemplate.exchange("http://localhost:" + port + "/v2/catalog",
                                  HttpMethod.GET,
                                  new HttpEntity<Object>(getAuthHeader(username, password)),
                                  String.class);
        System.out.println("responseEntity = " + responseEntity.getBody());
    }

    @Test
    public void TestCatalogBadAuth() {
        ResponseEntity<String> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange("http://localhost:" + port + "/v2/catalog",
                                  HttpMethod.GET,
                                  new HttpEntity<Object>(getAuthHeader("bad", "bad")),
                                  String.class);
        }
        catch (HttpClientErrorException e) {
            assert e.getStatusCode() == HttpStatus.UNAUTHORIZED;
        }
    }

    private HttpHeaders getAuthHeader(final String uid, final String pwd) {
        String authHeader = "Basic " + Base64.encodeBase64String((uid + ":" + pwd).getBytes(Charset.forName("UTF-8")));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authentication", authHeader);
        return headers;
    }
}
