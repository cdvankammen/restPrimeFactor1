package com.example.restprimefactor;

import com.example.restprimefactor.controller.RestPrimeFactorController;
import com.example.restprimefactor.dto.PrimeFactorsJsonObject;
import com.example.restprimefactor.service.RestPrimeFactorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class RestPrimeFactorControllerTest {
    @Autowired
    private RestPrimeFactorController restPrimeFactorController;
    private int NUMBER_TO_FACTOR = 20;
    private List<Integer> PRIME_FACTOR_LIST = Arrays.asList(2,2,5);
    private HttpStatus STATUS = HttpStatus.OK;

    private ResponseEntity<PrimeFactorsJsonObject> RESPONSE_ENTITY =
            new ResponseEntity<>(new PrimeFactorsJsonObject(NUMBER_TO_FACTOR,
                    PRIME_FACTOR_LIST),STATUS);
    @Test
    void testGetPrimeNumberFactors(){
        ResponseEntity<PrimeFactorsJsonObject> jsonEntity = restPrimeFactorController.getPrimeNumberFactors(NUMBER_TO_FACTOR);

        //NULL CHECKS
        assertThat(jsonEntity, is(notNullValue()));

        //utility checks
        assertThat(jsonEntity, is(equalTo(RESPONSE_ENTITY.));
    }

}
