package org.example.memo.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberResponseDto {
    private final String username;
    private final String email;
    private final LocalDateTime createDate;
    private final LocalDateTime modifiedDate;

    public MemberResponseDto(String username, String email, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.username = username;
        this.email = email;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}