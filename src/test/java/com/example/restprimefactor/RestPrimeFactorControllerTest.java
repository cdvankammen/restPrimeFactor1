package com.example.restprimefactor;

import com.example.restprimefactor.controller.ExceptionHandlerController;
import com.example.restprimefactor.controller.RestPrimeFactorController;
import com.example.restprimefactor.model.PrimeFactorsJsonObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RestPrimeFactorControllerTest {
    @Autowired
    private MockMvc mockTest;

    @Autowired
    private RestPrimeFactorController restPrimeFactorController;

    private final int NUMBER_TO_FACTOR = 20;
    private final List<Integer> PRIME_FACTOR_LIST = Arrays.asList(2,5);
    private final HttpStatus STATUS = HttpStatus.OK;
    private final String INVALID_INPUT = "3.2342d,";

    private final ResponseEntity<PrimeFactorsJsonObject> RESPONSE_ENTITY = new ResponseEntity<>(new PrimeFactorsJsonObject(NUMBER_TO_FACTOR, PRIME_FACTOR_LIST),STATUS);



    @Test
    void testGetPrimeNumberFactors() {
        ResponseEntity<PrimeFactorsJsonObject> jsonEntity = restPrimeFactorController.getPrimeNumberFactors(NUMBER_TO_FACTOR);

        //NULL CHECKS
        assertThat(jsonEntity, is(notNullValue()));

        //FUNCTIONALITY CHECK
        assertThat(jsonEntity.getStatusCode(), is(equalTo(RESPONSE_ENTITY.getStatusCode())));

        assertThat(jsonEntity.getBody().listOfFactors, is(equalTo(RESPONSE_ENTITY.getBody().listOfFactors))); //confirm list is correct
    }
    @Test
    void testInvalidValueInputs() throws Exception {
        this.mockTest.perform(MockMvcRequestBuilders.get(INVALID_INPUT)).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("Please provide a valid integer to factor"));

        /*
       //ResponseEntity<PrimeFactorsJsonObject> jsonEntity =
                restPrimeFactorController.getPrimeNumberFactors(INVALID_INPUT);

        //NULL CHECKS
        assertThat(jsonEntity, is(notNullValue()));

        //FUNCTIONALITY CHECK
        assertThat(jsonEntity.getStatusCode(), is(equalTo(HttpStatus.OK)));
*/

    }

    @Test
    void testMoreThanOneValueGetFactor(){

    }
}
