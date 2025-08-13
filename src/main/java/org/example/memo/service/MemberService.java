package org.example.memo.service;

import lombok.RequiredArgsConstructor;
import org.example.memo.dto.MemberResponseDto;
import org.example.memo.dto.SignUpResponseDto;
import org.example.memo.entity.Member;
import org.example.memo.entity.Memo;
import org.example.memo.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public SignUpResponseDto signUp(String username, String email, String password) {

        Member member = new Member(username, email, password);
        Member savedMember = memberRepository.save(member);

        return new SignUpResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getEmail(), savedMember.getCreatedDate(), savedMember.getModifiedDate());
    }

    public MemberResponseDto findById(Long id) {
        Optional<Member> optionalMember = memberRepository.findById(id);
        // NPE 방지
        if (optionalMember.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
        Member findMember = optionalMember.get();

        return new MemberResponseDto(findMember.getUsername(), findMember.getEmail(), findMember.getCreatedDate(), findMember.getModifiedDate());
    }

    @Transactional
    public void updateMember(Long id, String username, String email) {
        Member findMember = memberRepository.findByIdOrElseThrow(id);
        findMember.updateMember(username, email);
    }

    @Transactional
    public void delete(Long id) {
        Member findMember = memberRepository.findByIdOrElseThrow(id);
        memberRepository.delete(findMember);
    }

    //유저가 한명이라도 있는지 확인
    //Filter를 통해 애초에 로그인 하지 않으면 검색 조차 불가능 하다
    //로그인을 했다면 유저는 1명 이상 있다는 뜻
    public MemberResponseDto findId() {
        Member member = memberRepository.findById(1L).orElseThrow(
                ()-> new IllegalArgumentException("그런 사람 없음")
        );
        return new MemberResponseDto(member.getUsername(), member.getEmail(), member.getCreatedDate(), member.getModifiedDate());
    }

    @Transactional
    public Member authenticate(String email, String password){
        Member auth = memberRepository.findByEmail(email).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email 을 잘 못 입력하셨습니다.")
        );
        if(!auth.getPassword().equals(password)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Password 가 일치하지 않습니다.");
        }
        return auth;
    }
}