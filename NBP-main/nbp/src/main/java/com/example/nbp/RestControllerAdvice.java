package com.example.nbp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {
    @ExceptionHandler(HttpClientErrorException.class)
    ResponseEntity<String> HandlerRuntimeExecption(HttpClientErrorException exception) {
        // ResponseEntity<String> q=null;
        switch (exception.getStatusCode()){
            case INTERNAL_SERVER_ERROR :
                return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Exception thorw: 123" );
            case  NOT_FOUND:
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exception thorw: 234" );
            case BAD_REQUEST:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Exception thorw: 345" );
            case NO_CONTENT:
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Exception thorw: 456" );
        }
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Exception thorw: 567" );

    }
}
