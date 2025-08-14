package org.example.memo.dto;

import lombok.Getter;

@Getter
public class CreateMemoRequestDto {

    //요청값(유저명, 제목, 내용)
//    private final String username;
    private final String title;
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