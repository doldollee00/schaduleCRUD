package org.example.memo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateMemoRequestDto {

    //요청값(유저명, 제목, 내용)
//    private final String username;
    @NotBlank
    @Size(min = 1, max = 100)
    private final String title;
    @NotNull
    private final String contents;

//    public CreateMemoRequestDto(String username, String title, String contents) {
//        this.username = username;
//        this.title = title;
//        this.contents = contents;
//    }

    public CreateMemoRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}