package org.example.memo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.memo.dto.CreateMemoRequestDto;
import org.example.memo.dto.MemoGetResponseDto;
import org.example.memo.dto.MemoResponseDto;
import org.example.memo.dto.UpdateMemoRequestDto;
import org.example.memo.service.MemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members/{memberId}/memos")
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    //회원 로그인 후 메모 작성
    @PostMapping
    public ResponseEntity<MemoResponseDto> create(@Valid @RequestBody CreateMemoRequestDto requestDto, @PathVariable Long memberId) {

        MemoResponseDto memoResponseDto =
                memoService.save(
                        requestDto.getTitle(),
                        requestDto.getContents(),
                        memberId
                );
        return new ResponseEntity<>(memoResponseDto, HttpStatus.CREATED);
    }

    //메모 작성
    //    @PostMapping
//    public ResponseEntity<MemoResponseDto> save(@RequestBody CreateMemoRequestDto requestDto) {
//
//        MemoResponseDto memoResponseDto =
//                memoService.save(requestDto.getUsername(),
//                        requestDto.getTitle(),
//                        requestDto.getContents()
//                );
//        return new ResponseEntity<>(memoResponseDto, HttpStatus.CREATED);
//    }

    //작성된 메모를 id를 기준으로 검색
    @GetMapping("/{id}")
    public ResponseEntity<MemoGetResponseDto> findById(@PathVariable Long id) {
        MemoGetResponseDto memoGetResponseDto = memoService.findById(id);

        return new ResponseEntity<>(memoGetResponseDto, HttpStatus.OK);
    }

    //작성된 메모를 전체 검색
    @GetMapping
    public ResponseEntity<List<MemoResponseDto>> findAll() {
        List<MemoResponseDto> memoResponseDtoList = memoService.findAll();
        return new ResponseEntity<>(memoResponseDtoList, HttpStatus.OK);
    }

    //작성된 메모 내용 변경
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateMemo(@PathVariable Long id, @Valid @RequestBody UpdateMemoRequestDto requestDto) {
        memoService.updateMemo(id, requestDto.getTitle(), requestDto.getContents());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //메모 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        memoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
