package org.example.memo.service;

import lombok.RequiredArgsConstructor;
import org.example.memo.dto.MemoGetResponseDto;
import org.example.memo.dto.MemoResponseDto;
import org.example.memo.entity.Member;
import org.example.memo.entity.Memo;
import org.example.memo.repository.MemberRepository;
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
@Transactional(readOnly = true)
public class MemoService {

    private final MemoRepository memoRepository;
    private final MemberRepository memberRepository;

    //회원 로그인 후 메모 작성
    @Transactional
    public MemoResponseDto save(String title, String contents, Long memberId) {
        Member member =  memberRepository.findById(memberId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "없는 멤버 입니다."));
        Memo memo = new Memo(title, contents, member);
        Memo savedMemo = memoRepository.save(memo);

        return new MemoResponseDto(
                savedMemo.getId(),
                savedMemo.getTitle(),
                savedMemo.getContents(),
                savedMemo.getCreatedDate(),
                savedMemo.getModifiedDate()
        );
    }

    //메모 작성
    //    @Transactional
//    public MemoResponseDto save(String username, String title, String contents) {
//        Memo memo = new Memo(username, title, contents);
//        Memo savedMemo = memoRepository.save(memo);
//
//        return new MemoResponseDto(
//                savedMemo.getId(),
//                savedMemo.getUsername(),
//                savedMemo.getTitle(),
//                savedMemo.getContents(),
//                savedMemo.getCreatedDate(),
//                savedMemo.getModifiedDate()
//        );
//    }

    public MemoGetResponseDto findById(Long id) {

        Optional<Memo> optionalMemo = memoRepository.findById(id);
        if (optionalMemo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Memo Not Found");
        }

        Memo findMemo = optionalMemo.get();

        return new MemoGetResponseDto(
                findMemo.getId(),
                findMemo.getTitle(),
                findMemo.getContents(),
                findMemo.getCreatedDate(),
                findMemo.getModifiedDate()
        );
    }

    public List<MemoResponseDto> findAll() {
        List<Memo> memos = memoRepository.findAll();
        List<MemoResponseDto> dtos = new ArrayList<>();

        for(Memo memo : memos){
            MemoResponseDto memoResponseDto = new MemoResponseDto(
                    memo.getId(),
                    memo.getTitle(),
                    memo.getContents(),
                    memo.getCreatedDate(),
                    memo.getModifiedDate()
            );
            dtos.add(memoResponseDto);
        }
        return dtos;
    }

    @Transactional
    public void updateMemo(Long id, String title, String contents) {
        Memo findMemo = memoRepository.findByIdOrElseThrow(id);
        findMemo.updateMemo(title, contents);
    }
    @Transactional
    public void delete(Long id) {
        Memo findMemo = memoRepository.findByIdOrElseThrow(id);
        memoRepository.delete(findMemo);
    }
}