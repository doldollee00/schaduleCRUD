package org.example.memo.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "memo")
public class Memo extends BaseEntity {

    //유저명, 제목, 내용, 작성일, 수정일 필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    public Memo() {
    }

    public Memo(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }

    public void updateMemo(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
