package com.prabhattechtest.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DailySummaryControllerTest {


    @Autowired
    private MockMvc mvc;

    @Test
    public void getSuccess() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/dailySummary").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getFailure() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/transaction").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}