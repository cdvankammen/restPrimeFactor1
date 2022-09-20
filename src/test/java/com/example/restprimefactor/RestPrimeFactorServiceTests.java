package com.example.restprimefactor;

import com.example.restprimefactor.service.RestPrimeFactorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class RestPrimeFactorServiceTests {
    @Autowired
    private RestPrimeFactorService restPrimeFactorService;

    private int PRIME_NUMBER = 20;
    private List<Integer> PRIME_FACTOR_LIST = Arrays.asList(1,2,5);


    @Test
    void getFactors(){
        List<Integer> listOfFactors = restPrimeFactorService.factor(PRIME_NUMBER);
        //Null Checks
        assertThat(listOfFactors, is(not(nullValue())));

        //Correct value check
        assertThat(listOfFactors, is(equalTo(PRIME_FACTOR_LIST)));
    }


}
