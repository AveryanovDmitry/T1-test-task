package ru.t1consulting.t1_test_task.controller;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MissingServletRequestParameterException;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class TestTaskControllerTest {
    private final MockMvc mvc;

    @Test
    void countsCorrectString() throws Exception {
        mvc.perform(get("http://localhost:8080/?string=aaaaabccc"))
                .andExpect(status()
                        .isOk()).andExpect(content().string("\"a\": 5, \"c\": 3, \"b\": 1"));
    }

    @Test
    void ifStringIsWrongThrowsException() throws Exception {
        mvc.perform(get("http://localhost:8080")).andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MissingServletRequestParameterException))
                .andExpect(result -> assertEquals("Required request parameter 'string' for method parameter type String is not present",
                        result.getResolvedException().getMessage()));
    }
}
