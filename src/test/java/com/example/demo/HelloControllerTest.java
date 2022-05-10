package com.example.demo;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService greetingService;

    @Test
    public void getGreetWebSvc() throws Exception {
        when(greetingService.greet()).thenReturn("Hella cesi classroom");    
        this.mockMvc.perform(MockMvcRequestBuilders
            .get("/")
            .contentType(MediaType.TEXT_PLAIN))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.content().string("Hello cesi classroom"));
    }
}