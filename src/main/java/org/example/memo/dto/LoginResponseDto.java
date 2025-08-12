package org.example.memo.dto;

import lombok.Getter;

@Getter
public class LoginResponseDto {

    private String username;
    private String email;

    public LoginResponseDto(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
