package org.example.memo.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class SignUpResponseDto {

    private final Long userId;
    private final String username;
    private final String email;
    private final LocalDateTime createDate;
    private final LocalDateTime modifiedDate;


    public SignUpResponseDto(Long userId, String username, String email,  LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}
