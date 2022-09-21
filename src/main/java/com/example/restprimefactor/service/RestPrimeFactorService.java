package com.example.restprimefactor.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestPrimeFactorService {
    //receives a number and returns its factors
    public List<Integer> factor(int numberToFactor){

        List<Integer> listOfFactors = new ArrayList<>();

        while (numberToFactor% 2 == 0) {
            listOfFactors.add(2);
            numberToFactor/= 2;
        }

        for (int i = 3; i <= Math.sqrt(numberToFactor); i += 2) {
            while (numberToFactor% i == 0) {
                listOfFactors.add(i);
                numberToFactor/= i;
            }
        }

        if (numberToFactor > 2) {
            listOfFactors.add(numberToFactor);
            System.out.println(numberToFactor);
        }

        return listOfFactors.stream().distinct().collect(Collectors.toList());
    }
}
