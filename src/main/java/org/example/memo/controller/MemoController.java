package org.example.memo.controller;

import lombok.RequiredArgsConstructor;
import org.example.memo.dto.CreateMemoRequestDto;
import org.example.memo.dto.MemoGetResponseDto;
import org.example.memo.dto.MemoResponseDto;
import org.example.memo.dto.UpdateMemoRequestDto;
import org.example.memo.repository.MemoRepository;
import org.example.memo.service.MemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memos")
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @PostMapping
    public ResponseEntity<MemoResponseDto> save(@RequestBody CreateMemoRequestDto requestDto) {

        MemoResponseDto memoResponseDto =
                memoService.save(requestDto.getUsername(),
                                 requestDto.getTitle(),
                                 requestDto.getContents()
                        );
        return new ResponseEntity<>(memoResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemoGetResponseDto> findById(@PathVariable Long id) {
        MemoGetResponseDto memoGetResponseDto = memoService.findById(id);

        return new ResponseEntity<>(memoGetResponseDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MemoResponseDto>> findAll() {
        List<MemoResponseDto> memoResponseDtoList = memoService.findAll();
        return new ResponseEntity<>(memoResponseDtoList, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateMemo(@PathVariable Long id, @RequestBody UpdateMemoRequestDto requestDto) {
        memoService.updateMemo(id, requestDto.getTitle(), requestDto.getContents());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
