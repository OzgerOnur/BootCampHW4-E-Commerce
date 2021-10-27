package com.kodluyoruz.weekFourHomework.exceptions;

import com.kodluyoruz.weekFourHomework.exceptions.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionsHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> notFoundException(NotFoundException exception){
        log.trace("Not Found Is Created");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> unknownError(RuntimeException exception){
        log.error("AN UNKONW ERROR OCCURED : " + exception.getStackTrace()+"\n++\n"+exception.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("unknown Error");

    }
}
