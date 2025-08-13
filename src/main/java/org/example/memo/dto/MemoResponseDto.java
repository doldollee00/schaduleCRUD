package org.example.memo.dto;

import lombok.Getter;
import org.example.memo.entity.Member;
import org.example.memo.entity.Memo;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
public class MemoResponseDto {

    //응답값(id, 유저명, 제목, 내용, 생성날짜, 삭제날짜)
    private final Long id;
//    private final String username;
    private final String title;
    private final String contents;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

//    public MemoResponseDto(Long id, String username, String title, String contents, LocalDateTime createdDate, LocalDateTime modifiedDate) {
//        this.id = id;
//        this.username = username;
//        this.title = title;
//        this.contents = contents;
//        this.createdDate = createdDate;
//        this.modifiedDate = modifiedDate;
//    }

    //Member 연관관계 생성자 (username 삭제)
    public MemoResponseDto(Long id, String title, String contents, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}