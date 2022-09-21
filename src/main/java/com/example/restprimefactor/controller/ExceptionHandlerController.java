package com.example.restprimefactor.controller;


import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionHandlerController extends Exception{

    @ExceptionHandler
    public String errorHandlingWrongInput(Exception e){
        return "Please provide a valid integer to factor";
    }


}
