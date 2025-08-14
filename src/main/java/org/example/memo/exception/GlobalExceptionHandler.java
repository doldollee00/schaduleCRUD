//package org.example.memo.exception;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.ErrorResponse;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleAll(Exception ex) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body("에러 발생: " + ex.getMessage());
//    }
//
//    @ExceptionHandler(CustomeException.class)
//    public ResponseEntity<ErrorResponse> handleCustomException(CustomeException ex, HttpServletRequest request) {
//        ErrorResponse error = ErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getCode(), ex.getMessage(), request.getRequestURI());
//        return ResponseEntity.badRequest().body(error);
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {
//        ErrorResponse error = ErrorResponse.of(HttpStatus.BAD_REQUEST, "VAL-000", message, request.getRequestURI());
//        return ResponseEntity.badRequest().body(error);
//    }
//}
