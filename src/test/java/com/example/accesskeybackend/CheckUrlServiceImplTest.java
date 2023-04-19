package com.example.accesskeybackend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CheckUrlServiceImplTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCheckIpv6SupportWithValidUrl() {
        String url = "https://www.google.com";
        ResponseEntity<Boolean> response = restTemplate.getForEntity("/api/web/checkIpv6Support?siteUrl=" + url, Boolean.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(true, response.getBody());
    }

    @Test
    void testCheckIpv6SupportWithInvalidUrl() {
        String url = "invalid_url";
        ResponseEntity<Boolean> response = restTemplate.getForEntity("/api/web/checkIpv6Support?siteUrl=" + url, Boolean.class);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Assertions.assertEquals(false, response.getBody());
    }
}

