package com.practice.ecommorce.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Token {
    private int id;
    @JsonProperty("value")
    private String value;
    @JsonProperty("user")
    private User user;
    @JsonProperty("expires_at")
    private Date expiresAt;
    @JsonProperty("is_active")
    private boolean isActive;
}
