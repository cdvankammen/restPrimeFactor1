package com.example.restprimefactor;

import com.example.restprimefactor.controller.RestPrimeFactorController;
import com.example.restprimefactor.model.PrimeFactorsJsonObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.validation.annotation.Validated;

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

    private final int VALID_INPUT = 20;
    private final List<Integer> PRIME_FACTOR_LIST = Arrays.asList(2,5);
    private final HttpStatus STATUS = HttpStatus.OK;
    private final String INVALID_INPUT = "3.2342d,";

    private final ResponseEntity<PrimeFactorsJsonObject> RESPONSE_ENTITY = new ResponseEntity<>(new PrimeFactorsJsonObject(VALID_INPUT, PRIME_FACTOR_LIST),STATUS);



    @Test
    void testGetPrimeNumberFactors() throws Exception {
                mockTest.perform(MockMvcRequestBuilders.get("/"+ VALID_INPUT)).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().json("{\"number\":20,\"listOfFactors\":[2,5]}"));

    }
    @Test
    void testInvalidValueInputs() throws Exception {
        this.mockTest.perform(MockMvcRequestBuilders.get("/"+ INVALID_INPUT)).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("Please provide a valid integer to factor"));

    }

    @Test
    void testWelcomeScreen() throws Exception {
        this.mockTest.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("Welcome to rest prime factor the way to show the prime " +
                "factors for a specific number!" + System.lineSeparator() +
                "Put Number after " + "the \" / \" in the URL to see results"));

    }
}
