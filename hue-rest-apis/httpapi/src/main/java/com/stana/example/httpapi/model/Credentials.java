package com.stana.example.httpapi.model;

import lombok.Data;

@Data
public class Credentials {

    private String username;
    private String password;
    private String csrfmiddlewaretoken;
}
