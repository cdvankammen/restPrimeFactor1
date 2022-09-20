package com.example.restprimefactor.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class primeFactors {
    private int number; //number to be factored
    private List<Integer> listOfFactors;

}
