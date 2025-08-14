package org.example.memo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateMemoRequestDto {

    @NotBlank
    @Size(min = 1, max = 100)
    private final String title;
    @NotNull
    private final String contents;

    public UpdateMemoRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}