package com.kryose.kryose.Entity;

import java.io.Serializable;

public class AuthResponse implements Serializable {


    private final String jwt;



    public AuthResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
