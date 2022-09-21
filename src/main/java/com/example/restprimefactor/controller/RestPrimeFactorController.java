package com.example.restprimefactor.controller;

import com.example.restprimefactor.model.PrimeFactorsJsonObject;
import com.example.restprimefactor.service.RestPrimeFactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Logger;


@RestController
public class RestPrimeFactorController {
    @Autowired
    private RestPrimeFactorService restPrimeFactorService;

    //Provide instructions for the user to begin
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String welcomeText(){
        return restPrimeFactorService.welcomeScreen();
    }

    @GetMapping("/{number}")
    public ResponseEntity<PrimeFactorsJsonObject> getPrimeNumberFactors(@PathVariable int number ) {
        //Return the factors of Number given with JSON output
        //list of all factors given the number
        List<Integer> listOfFactors = restPrimeFactorService.factor(number);

        if(!listOfFactors.isEmpty()) {
            return new ResponseEntity<>(new PrimeFactorsJsonObject(number,listOfFactors), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new PrimeFactorsJsonObject(number,
                    listOfFactors),HttpStatus.NO_CONTENT);
        }
    }

    @ExceptionHandler
    public String errorHandlingWrongInput(Exception e){
        Logger.getLogger("Error with Rest Prime Factor Controller" + e);
        return restPrimeFactorService.invalidInput();
    }




}
