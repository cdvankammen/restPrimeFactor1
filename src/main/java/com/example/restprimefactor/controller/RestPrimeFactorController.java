package com.example.restprimefactor.controller;

import com.example.restprimefactor.dto.PrimeFactorsJsonObject;
import com.example.restprimefactor.service.RestPrimeFactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

@RestController
public class RestPrimeFactorController {
    @Autowired
    private RestPrimeFactorService restPrimeFactorService;

    //Provide instructions for the user to begin
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String welcomeText(){
        return "Welcome to rest prime factor the way to show the prime " +
                "factors for your number! \n TO BEGIN: \n put a number after " +
                "the \" / \" in the URL";
    }

    @GetMapping("/{number}")
    public ResponseEntity<PrimeFactorsJsonObject> getPrimeNumberFactors(@PathVariable int number){
        //Return the factors of Number given with JSON output
        //list of all factors given the number
        List<Integer> listOfFactors = restPrimeFactorService.factor(number);

        if(!listOfFactors.isEmpty()) {
            return new ResponseEntity<>(new PrimeFactorsJsonObject(number,listOfFactors), HttpStatus.OK);
        }
        else {
            errorHandlingWrongInput();
            return ResponseEntity.noContent().build();
        }
    }

    @ExceptionHandler(NumberFormatException.class)
    public String errorHandlingWrongInput(){
        return "Please provide a valid integer to factor";
    }

}
