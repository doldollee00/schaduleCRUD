package org.example.memo.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {

    private final String username;
    private final String email;
    private final Long password;

    public SignUpRequestDto(String username, String email, Long password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
