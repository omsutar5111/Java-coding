package com.practice.ecommorce.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class SimpleTokenDto {
    private int id;
    private String value;
    private Date expiresAt;
    private boolean active;

    public SimpleTokenDto() {
    }

    public SimpleTokenDto(int id, String value, Date expiresAt, boolean active) {
        this.id = id;
        this.value = value;
        this.expiresAt = expiresAt;
        this.active = active;
    }
}
