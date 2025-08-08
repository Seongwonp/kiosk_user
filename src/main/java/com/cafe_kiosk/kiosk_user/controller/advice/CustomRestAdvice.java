package com.cafe_kiosk.kiosk_user.controller.advice;

import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Log4j2
@RestControllerAdvice
public class CustomRestAdvice {
    @ExceptionHandler(BindException.class) //컨트롤러에서 bindException 발생 시 메서드가 실행
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ResponseEntity<Map<String, String>> handleBindException(BindException ex){
        /* 유효성 검사에서 문제가 발생한 경우, 결과를 json 형태로 반환하기 위한 메서드 */
        log.error(ex);

        Map<String, String> errorsMap= new HashMap<>(); //에러내용을 저장하기 위함

        if (ex.hasErrors()){
            BindingResult bindingResult =ex.getBindingResult();

            bindingResult.getFieldErrors().forEach((fieldError)->{
                errorsMap.put(fieldError.getField(), fieldError.getCode());
            });
        }


        return ResponseEntity.badRequest().body(errorsMap);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ResponseEntity<Map<String, String>> handleFKException(DataIntegrityViolationException ex){
        //fk 문제가 발생한 경우, 결과를 json 형태로 반환하기 위한 메서드
        log.error(ex);
        Map<String, String> errorsMap= new HashMap<>();
        errorsMap.put("time", String.valueOf(System.currentTimeMillis()));
        errorsMap.put("message", "constraint fails");
        return ResponseEntity.badRequest().body(errorsMap);
    }
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ResponseEntity<Map<String, String>> handleNoSuchElementException(NoSuchElementException ex){
        //rno 문제가 발생한 경우, 결과를 json 형태로 반환하기 위한 메서드
        log.error(ex);
        Map<String, String> errorsMap= new HashMap<>();
        errorsMap.put("time", String.valueOf(System.currentTimeMillis()));
        errorsMap.put("message", "no such element");
        return ResponseEntity.badRequest().body(errorsMap);
    }

}
