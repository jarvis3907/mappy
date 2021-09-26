package com.mappy.fizzbuzz.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mappy.fizzbuzz.AuditRepository;
import com.mappy.fizzbuzz.model.HitResponse;
import com.mappy.fizzbuzz.model.Request;
import com.mappy.fizzbuzz.model.Result;
import com.mappy.fizzbuzz.service.impl.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mappy.fizzbuzz.utils.TestUtils.asJsonString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The type Foo bar qix controller it.
 */
@AutoConfigureMockMvc
@ContextConfiguration(classes = {FizzBuzzController.class, FizzBuzzService.class})
@WebMvcTest
public class FizzBuzzControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AuditRepository auditRepository;


    /**
     * Test computing.
     *
     * @throws Exception the exception
     */
    @Test
    public void testComputing() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/compute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(Request.builder().firstNumber(3).firstWord("fizz").secondNumber(5).secondWord("buzz").limit(5).build())))
                .andExpect(status().isOk())
                .andReturn();

        String resultantResponse = result.getResponse().getContentAsString();
        assertNotNull(resultantResponse);
        Result resultant = objectMapper.readValue(resultantResponse, Result.class);
        assertEquals(Arrays.asList("1", "2", "fizz", "4", "buzz"), resultant.getResult());
    }


    /**
     * Test computing with blank first word.
     *
     * @throws Exception the exception
     */
    @Test
    public void testComputingWithBlankFirstWord() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/compute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(Request.builder().firstNumber(3).firstWord("").secondNumber(5).secondWord("buzz").limit(5).build())))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    /**
     * Test computing with blank second word.
     *
     * @throws Exception the exception
     */
    @Test
    public void testComputingWithBlankSecondWord() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/compute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(Request.builder().firstNumber(3).firstWord("fizz").secondNumber(5).secondWord("").limit(5).build())))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    /**
     * Test computing with negative first number.
     *
     * @throws Exception the exception
     */
    @Test
    public void testComputingWithNegativeFirstNumber() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/compute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(Request.builder().firstNumber(-3).firstWord("").secondNumber(5).secondWord("buzz").limit(5).build())))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    /**
     * Test computing with negative second number.
     *
     * @throws Exception the exception
     */
    @Test
    public void testComputingWithNegativeSecondNumber() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/compute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(Request.builder().firstNumber(3).firstWord("").secondNumber(-5).secondWord("buzz").limit(5).build())))
                .andExpect(status().isBadRequest())
                .andReturn();
    }


    @Test
    public void testComputingWithNegativeLimit() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/compute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(Request.builder().firstNumber(3).firstWord("").secondNumber(5).secondWord("buzz").limit(-5).build())))
                .andExpect(status().isBadRequest())
                .andReturn();
    }


    @Test
    public void testStatistics() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/compute/statistics")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

}
