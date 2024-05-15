package com.nikita.productservice.controllers;

import com.nikita.productservice.dto.ErrorResponceDto;
import com.nikita.productservice.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class ExceptionAsvices {
        @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponceDto> Nikita(Exception exception){
        ErrorResponceDto errorResponceDto=new ErrorResponceDto();
        errorResponceDto.setErrorMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponceDto, HttpStatus.NOT_FOUND);


     }
}
