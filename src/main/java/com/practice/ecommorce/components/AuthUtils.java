package com.practice.ecommorce.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.practice.ecommorce.dtos.SimpleTokenDto;

@Component
public class AuthUtils {

    private RestTemplate restTemplate;

    @Autowired
    public AuthUtils(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean validateToken(String tokenValue) {
        String url = "http://localhost:8081/user/validate-token";
        String body = "{\"token\":\"" + tokenValue + "\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(body, headers);

        try {
            // Use SimpleTokenResponse class to map the response
            ResponseEntity<SimpleTokenDto> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    httpEntity,
                    SimpleTokenDto.class);

            // Check if response status is 200 OK and token is not null
            if (response.getStatusCode() == HttpStatus.OK) {
                SimpleTokenDto tokenResponse = response.getBody();
                System.out.println(tokenResponse);
                System.out.println(tokenResponse.getValue());
                if (tokenResponse != null && tokenResponse.getValue().equals(tokenValue)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace();
            return false;
        }

    }
}
