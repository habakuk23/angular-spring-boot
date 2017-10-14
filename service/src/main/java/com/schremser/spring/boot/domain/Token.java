package com.schremser.spring.boot.domain;

import com.auth0.jwt.JWT;
import jersey.repackaged.com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public class Token {
    private static Map<String, String> tokenMap = new HashMap<>();
    String token;

    static {
        tokenMap.putAll(ImmutableMap.of(
                "maxi@schremser.com", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJuZ0FwcCIsIm5hbWUiOiJNYXggU2NocmVtc2VyIiwiYWRtaW4iOnRydWUsImVtYWlsIjoibWF4aUBzY2hyZW1zZXIuY29tIn0.NJftk2YAruAS0yMlidPYyLmISdJoMl5M10D_xjMqJl0"
        ));

    }

    public Token(Credentials credentials) {
        setToken(credentials.email, tokenMap.get(credentials.email));
    }

    public String getToken(Object key) {
        return tokenMap.get(key);
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setToken(String email, String token) {
        JWT jwt = JWT.decode(token);
        boolean isNgApp = jwt.getSubject().equals("ngApp");
        boolean isUser  = jwt.getClaim("email").asString().equals(email);
        if (isNgApp && isUser)
            tokenMap.put(email, token);
        setToken(token);
    }
}
