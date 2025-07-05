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

@SpringBootTest
@AutoConfigureMockMvc
public class StringStrategy02Testing {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("testNormalCase")
    void testNormalCase() throws Exception {
        //1. aabbbdddeeeffkkkaaaccc -> acdffjb
        //2. acdffjb -> cdffjb
        mockMvc.perform(MockMvcRequestBuilders.get("/api/remove")
                .param("input", "aabbbdddeeeffkkkaaaccc")
                .param("strategy", "stringStrategy02"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value("success"))
                .andExpect(jsonPath("$.data").value("cdffjb"));
    }

    @Test
    @DisplayName("testNoCharA")
    void testNoCharA() throws Exception {
        //1. bbcccffdddkkiii -> bbbffckkh
        //2. bbbffckkh -> affckkh
        mockMvc.perform(MockMvcRequestBuilders.get("/api/remove")
                .param("input", "bbcccffdddkkiii")
                .param("strategy", "stringStrategy02"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value("success"))
                .andExpect(jsonPath("$.data").value("affckkh"));
    }

    @Test
    @DisplayName("testFinalEmpty")
    void testFinalEmpty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/remove")
                .param("input", "aabbb")
                .param("strategy", "stringStrategy02"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value("success"))
                .andExpect(jsonPath("$.data").value(""));

    }
}
