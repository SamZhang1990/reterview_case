package com.sam.zhang.stringremove;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
public class StringStrategy01Testing {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("testNormal")
    void testNormal() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/remove")
                .param("input","abbbcccdddaaee")
                .param("strategy", "stringStrategy01"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value("success"))
                .andExpect(jsonPath("$.data").value("ee"));
    }

    @Test
    @DisplayName("testNoCharContinue3Times")
    void testNoCharContinue3Times() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/remove")
                .param("input", "abcabccddee")
                .param("strategy", "stringStrategy01"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value("success"))
                .andExpect(jsonPath("$.data").value("abcabccddee"));
    }

    @Test
    @DisplayName("testInvalidInput")
    void testInvalidInput() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/remove")
                .param("input", "")
                .param("strategy", "stringStrategy01"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(400))
                .andExpect(jsonPath("$.message").value("Invalid Input"))
                .andExpect(jsonPath("$.data").doesNotExist());
    }

    @Test
    @DisplayName("testInvalidStrategy")
    void testInvalidStrategy() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/remove")
                .param("input", "abcd")
                .param("strategy", "InvalidStrategy"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(400))
                .andExpect(jsonPath("$.message").value("Invalid Strategy"))
                .andExpect(jsonPath("$.data").doesNotExist());
    }

}
