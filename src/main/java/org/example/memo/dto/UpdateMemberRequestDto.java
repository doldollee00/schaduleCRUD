package org.example.memo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateMemberRequestDto {

    @NotBlank
    private final String username;
    @Email @NotBlank
    private final String email;

    public UpdateMemberRequestDto(String username, String email) {
        this.username = username;
        this.email = email;
    }
}