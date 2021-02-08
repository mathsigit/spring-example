package com.stana.example.httpapi.service;

import com.stana.example.httpapi.model.Credentials;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import javax.annotation.PostConstruct;

@Component
public class HueLogin {
    final String HUE_URL_LOGIN ="https://demo.gethue.com/hue/accounts/login?next=/";
    final String HUE_URL_META="https://demo.gethue.com/metastore/databases/default/metadata";
    final String SET_COOKIE = "Set-Cookie";

    @PostConstruct
    public void login(){
        RestTemplate template = new RestTemplate();
        Credentials cred = new Credentials();

        HttpHeaders httpHeaders = template
                .getForEntity(HUE_URL_LOGIN, String.class)
                .getHeaders();

        cred.setUsername("demo");
        cred.setPassword("demo");
        cred.setCsrfmiddlewaretoken(extractCsrfToken(httpHeaders));

        ResponseEntity<String> response = template
                .postForEntity(HUE_URL_META, cred,String.class);
        System.out.println("Response: " + response.toString() + "\n");
        System.out.println("********* FINISH *******");
    }


    private String extractCsrfToken(HttpHeaders headers) {
        String setCookieHeader =  headers.get(SET_COOKIE).get(2);
        return setCookieHeader.substring(setCookieHeader.indexOf('=') + 1, setCookieHeader.indexOf(';'));
    }
}
