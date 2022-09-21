package com.example.restprimefactor.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class RestPrimeFactorService {
    //receives a number and returns its factors
    public List<Integer> factor(int numberToFactor) {

        List<Integer> listOfFactors = new ArrayList<>();
        if (numberToFactor > 1) {
            try {
                while (numberToFactor % 2 == 0) {
                    listOfFactors.add(2);
                    numberToFactor /= 2;
                }
                for (int i = 3; i <= Math.sqrt(numberToFactor); i += 2) {
                    while (numberToFactor % i == 0) {
                        listOfFactors.add(i);
                        numberToFactor /= i;
                    }
                }

                if (numberToFactor >= 2) {
                    listOfFactors.add(numberToFactor);
                }


            } catch (Exception e) {
                Logger.getLogger("Error in RestPrimeFactor Service:" + e);
            }
        }
        return listOfFactors.stream().distinct().collect(Collectors.toList());

    }

    public String welcomeScreen(){
        return  "Welcome to rest prime factor the way to show the prime " +
                "factors for a specific number!" + System.lineSeparator() +
                "Put Number after " + "the \" / \" in the URL to see results";
    }

    public String invalidInput(){
            return "Please provide a valid integer to factor";
    }
}
