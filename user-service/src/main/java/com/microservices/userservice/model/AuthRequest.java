package com.microservices.userservice.model;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
