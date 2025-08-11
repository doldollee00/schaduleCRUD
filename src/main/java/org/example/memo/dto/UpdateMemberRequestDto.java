package org.example.memo.dto;

import lombok.Getter;

@Getter
public class UpdateMemberRequestDto {

    private final String username;
    private final String email;

    public UpdateMemberRequestDto(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
