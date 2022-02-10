package com.safeTravel.payload.response;

import java.util.List;

public class JwtResponse {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private List<String> roles;
    private String type = "Bearer";
    private String token;

    public JwtResponse(String accessToken, Long id, String firstname, String lastname, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getRoles() {
        return roles;
    }
}
