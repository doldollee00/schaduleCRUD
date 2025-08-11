package org.example.memo.controller;

import lombok.RequiredArgsConstructor;
import org.example.memo.dto.MemberResponseDto;
import org.example.memo.dto.SignUpRequestDto;
import org.example.memo.dto.SignUpResponseDto;
import org.example.memo.dto.UpdateMemberRequestDto;
import org.example.memo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {
        SignUpResponseDto signUpResponseDto = memberService.signUp(requestDto.getUsername(), requestDto.getEmail());

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long userId) {
        MemberResponseDto memberResponseDto = memberService.findById(userId);
        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<Void> updateMember(@PathVariable Long userId, @RequestBody UpdateMemberRequestDto requestDto) {
        memberService.updateMember(userId, requestDto.getUsername(), requestDto.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
