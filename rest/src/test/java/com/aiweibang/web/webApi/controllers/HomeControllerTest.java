package com.aiweibang.web.webApi.controllers;

import com.aiweibang.web.webApi.BaseControllerTest;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class HomeControllerTest extends BaseControllerTest {

    @Test
    public void testStatus() throws Exception {
        mockMvc.perform(get("/status"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
        //text/html;charset=UTF-8


        ;
    }

    @Test
    public void testHome() throws Exception {
        mockMvc.perform(get("/api"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.status", is(true)))
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data", is("ok")));

    }
}