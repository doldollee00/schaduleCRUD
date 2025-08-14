package org.example.memo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.memo.dto.*;
import org.example.memo.entity.Member;
import org.example.memo.repository.MemberRepository;
import org.example.memo.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    //회원가입
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@Valid @RequestBody SignUpRequestDto requestDto) {
        SignUpResponseDto signUpResponseDto = memberService.signUp(requestDto.getUsername(), requestDto.getEmail(), requestDto.getPassword());

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    //회원 id기준 검색
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long id) {
        MemberResponseDto memberResponseDto = memberService.findById(id);
        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }

    //회원 id기준 정보 업데이트
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateMember(@PathVariable Long id, @Valid @RequestBody UpdateMemberRequestDto requestDto) {
        memberService.updateMember(id, requestDto.getUsername(), requestDto.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //회원 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        memberService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //회원 로그인
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto requestDto, HttpServletRequest request){
        Member authenticate = memberService.authenticate(requestDto.getEmail(), requestDto.getPassword());

        HttpSession session = request.getSession();    // 신규 세션 생성, JSESSIONID 쿠키 발급
        session.setAttribute("LOGIN_USER", authenticate.getUsername());   // 서버 메모리에 세션 저장
        return ResponseEntity.ok(new LoginResponseDto(authenticate.getUsername(), authenticate.getEmail()));
    }


    //로그아웃, 쿠키를 지워 주겠다 정도의 의미 (로그아웃의 경우는 필수 조건은 아니다. 왜냐면 보통 그냥 강종 하니깐)
    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        // 로그인하지 않으면 HttpSession이 null로 반환된다.
        HttpSession session = request.getSession(false);
        // 세션이 존재하면 -> 로그인이 된 경우
        if (session != null) {
            session.invalidate(); // 해당 세션(데이터)을 삭제한다.
        }
    }
}