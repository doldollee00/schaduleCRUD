package org.example.memo.service;

import lombok.RequiredArgsConstructor;
import org.example.memo.dto.MemberResponseDto;
import org.example.memo.dto.SignUpResponseDto;
import org.example.memo.entity.Member;
import org.example.memo.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public SignUpResponseDto signUp(String username, String email) {

        Member member = new Member(username, email);

        Member savedMember = memberRepository.save(member);

        return new SignUpResponseDto(savedMember.getUserId(), savedMember.getUsername(), savedMember.getEmail(), savedMember.getCreatedDate(), savedMember.getModifiedDate());
    }

    public MemberResponseDto findById(Long userId) {
        Optional<Member> optionalMember = memberRepository.findById(userId);

        // NPE 방지
        if (optionalMember.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + userId);
        }

        Member findMember = optionalMember.get();

        return new MemberResponseDto(findMember.getUsername(), findMember.getEmail(), findMember.getCreatedDate(), findMember.getModifiedDate());
    }

    @Transactional
    public void updateMember(Long userId, String username, String email) {
        Member findMember = memberRepository.findByIdOrElseThrow(userId);
        findMember.updateMember(username, email);
        
    }
}
