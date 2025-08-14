package org.example.memo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SignUpRequestDto {

    @NotBlank
    private final String username;
    @Email @NotBlank
    private final String email;
    @NotBlank
    @Size(min = 4)
    private final String password;

    public SignUpRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}