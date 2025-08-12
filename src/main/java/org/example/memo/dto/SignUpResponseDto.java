package org.example.memo.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SignUpResponseDto {

    private final Long id;
    private final String username;
    private final String email;
    private final LocalDateTime createDate;
    private final LocalDateTime modifiedDate;


    public SignUpResponseDto(Long id, String username, String email, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }
}
