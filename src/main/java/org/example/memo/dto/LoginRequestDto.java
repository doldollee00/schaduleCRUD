package org.example.memo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class LoginRequestDto {

    @Email @NotBlank
    private final String email;
    @NotBlank
    @Size(min = 4)
    private final String password;

    public LoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}