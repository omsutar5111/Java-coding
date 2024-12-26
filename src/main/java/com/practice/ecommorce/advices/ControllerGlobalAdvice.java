package com.practice.ecommorce.advices;

import com.practice.ecommorce.dtos.ErrorDto;
import com.practice.ecommorce.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerGlobalAdvice {
@ExceptionHandler(ProductNotFoundException.class)
//@SuppressWarnings("unused")
    public ResponseEntity<ErrorDto> handleControllerException(ProductNotFoundException productNotFoundException){
        ErrorDto errorDto=new ErrorDto();
        errorDto.setMessage(productNotFoundException.getMessage());
        errorDto.setStatus(HttpStatus.NOT_FOUND);
        return  new ResponseEntity<>(errorDto,HttpStatus.NOT_FOUND);
    }
}
