# 일정 관리 프로그램

## 프로젝트 개요
 - 프로젝트 목적: - CRUD에 대한 구조 복습 및 Cookie/Session을 활용한 인증/인가 → 보안 개념과 인증 메커니즘 이해
 - 주요 학습 목표: MVC(Model-View-Controller) 구조 각각의 책임에 대해 집중
 
### 기술 스택
 - Language: Java 17
 - Framework: Spring Boot version '3.5.4'
 - IDE: IntelliJ IDEA
 - JDK : corretto-17
 - Dependencies : Spring Web, Spring Data JPA, MySQL Driver, Lombok
 - MySQL : version 9.4.0
 
## 주요 기능
 - 회원 가입 (@Valid를 통한 검증 구현)
 - 로그인 (로그인 하지 않으면 주요 기능 미작동), (email, password 불일치 시 로그인 불가)
 - 일정 등록 (@Valid를 통한 검증 구현)
 - 일정 조회 (전체 조회 가능, 일정 Id를 기준 조회 가능)
 - 일정 수정 
 - 일정 삭제
 - 멤버 조회 (멤버 id를 기준 조회 가능)
 - 멤버 수정
 - 멤버 삭제
 
### 패키지 구조
<pre>
src/main/java/org.example.memo
├── controller
  ├── MemberController
  ├── MemoController
├── dto
  ├── CreateMemoRequestDto
  ├── LoginRequestDto
  ├── LoginResponseDto
  ├── MemberResponseDto
  ├── MemoGetResponseDto
  ├── MemoResponseDto
  ├── SignUpRequestDto
  ├── SignUpResponseDto
  ├── UpdateMemberRequestDto
  ├── UpdateMemoRequestDto
├── entity
  ├── BaseEntity
  ├── Member 
  ├── Memo
├── exception
  ├── GlobalExceptionHandler
├── filter
  ├── FilterConfig
  ├── LoginFilter
├── repository
  ├── MemberRepository  
  ├── MemoRepository  
├── service
  ├── MemberService 
  ├── MemoService  
├── MemoApplication
</pre>
 
## 트러블 슈팅
 - [프로젝트 TIL](https://dinga87.tistory.com/category/SPARTA%20%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8)
 
#### 미구현 목표
- 예외처리
- 비밀번호 암호화
- 댓글 CRUD
- 일정 페이징 조회
  
## API and ERD
 - [API and ERD 링크](https://dinga87.tistory.com/137)
 <img width="1364" height="1036" alt="image" src="https://github.com/user-attachments/assets/0083a0f6-9a6a-4bb6-b21e-28142d3851a2" />
 <img width="1267" height="856" alt="image" src="https://github.com/user-attachments/assets/51affa5b-b1b4-412b-a303-5994e109c3e7" />
 <img width="256" height="597" alt="image" src="https://github.com/user-attachments/assets/eb3de87b-3eb4-4032-9837-757ce3c53f2e" />



