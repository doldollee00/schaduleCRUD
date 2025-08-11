package org.example.memo.dto;

import lombok.Getter;

@Getter
public class UpdateMemoRequestDto {

    private final String title;
    private final String contents;

    public UpdateMemoRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
