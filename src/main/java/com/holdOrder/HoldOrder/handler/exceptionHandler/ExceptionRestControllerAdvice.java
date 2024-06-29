package com.holdOrder.HoldOrder.handler.exceptionHandler;

import com.holdOrder.HoldOrder.dto.error.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionRestControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalExceptionHandler(IllegalArgumentException exception) {
        return new ErrorResult("IllegalArgumentException", exception.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
    @ExceptionHandler // RuntimeException이 발생했을 경우 작동된다
    public ErrorResult exceptionHandler(Exception exception) {
        return new ErrorResult("RuntimeException", exception.getMessage());
    }


}
