package org.example.memo.service;

import lombok.RequiredArgsConstructor;
import org.example.memo.dto.MemoGetResponseDto;
import org.example.memo.dto.MemoResponseDto;
import org.example.memo.entity.Memo;
import org.example.memo.repository.MemoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public MemoResponseDto save(String username, String title, String contents) {
        Memo memo = new Memo(username, title, contents);
        Memo savedMemo = memoRepository.save(memo);

        return new MemoResponseDto(
                savedMemo.getId(),
                savedMemo.getUsername(),
                savedMemo.getTitle(),
                savedMemo.getContents(),
                savedMemo.getCreatedDate(),
                savedMemo.getModifiedDate()
        );
    }

    @Transactional(readOnly = true)
    public MemoGetResponseDto findById(Long id) {

        Optional<Memo> optionalMemo = memoRepository.findById(id);
        if (optionalMemo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Memo Not Found");
        }

        Memo findMemo = optionalMemo.get();

        return new MemoGetResponseDto(
                findMemo.getId(),
                findMemo.getUsername(),
                findMemo.getTitle(),
                findMemo.getContents(),
                findMemo.getCreatedDate(),
                findMemo.getModifiedDate()
        );
    }

    @Transactional(readOnly = true)
    public List<MemoResponseDto> findAll() {
        List<Memo> memos = memoRepository.findAll();
        List<MemoResponseDto> dtos = new ArrayList<>();

        for(Memo memo : memos){
            MemoResponseDto memoResponseDto = new MemoResponseDto(
                    memo.getId(),
                    memo.getUsername(),
                    memo.getTitle(),
                    memo.getContents(),
                    memo.getCreatedDate(),
                    memo.getModifiedDate()
            );
            dtos.add(memoResponseDto);
        }
        return dtos;
    }
}
