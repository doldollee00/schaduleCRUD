package org.example.memo.dto;

import lombok.Getter;
import org.example.memo.entity.Member;

import java.time.LocalDateTime;

@Getter
public class MemoGetResponseDto {

    //검색 응답(id, 유저명, 제목, 내용, 생성날짜, 수정날짜)
    private final Long id;
//    private final String username;
    private final String title;
    private final String contents;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

//    public MemoGetResponseDto(Long id, String username, String title, String contents, LocalDateTime createdDate, LocalDateTime modifiedDate) {
//        this.id = id;
//        this.username = username;
//        this.title = title;
//        this.contents = contents;
//        this.createdDate = createdDate;
//        this.modifiedDate = modifiedDate;
//    }

    public MemoGetResponseDto(Long id, String title, String contents, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}