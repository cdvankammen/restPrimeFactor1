package com.example.restprimefactor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class PrimeFactorsJsonObject {

    @JsonProperty("number")
    public Integer number;

    @JsonProperty("listOfFactors")
    public List<Integer> listOfFactors;


}
