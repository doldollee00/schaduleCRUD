package org.example.memo.service;

import lombok.RequiredArgsConstructor;
import org.example.memo.dto.SignUpResponseDto;
import org.example.memo.entity.Member;
import org.example.memo.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public SignUpResponseDto signUp(String username, String email) {

        Member member = new Member(username, email);

        Member savedMember = memberRepository.save(member);

        return new SignUpResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getEmail());
    }

}
