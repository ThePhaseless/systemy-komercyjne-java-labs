package com.sggw.lab2.controller;

import com.sggw.lab2.dto.SampleDto;
import com.sggw.lab2.service.SampleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SampleController.class)
class SampleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SampleService sampleService;

    @Test
    void helloReturnsFiveObjects() throws Exception {
        given(sampleService.process()).willReturn(List.of(
                new SampleDto("sample-1", "Anna", 20),
                new SampleDto("sample-2", "Bartek", 21),
                new SampleDto("sample-3", "Celina", 22),
                new SampleDto("sample-4", "Dawid", 23),
                new SampleDto("sample-5", "Ela", 24)
        ));

        mockMvc.perform(get("/api/samples/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(5))
                .andExpect(jsonPath("$[0].id").value("sample-1"))
                .andExpect(jsonPath("$[0].name").value("Anna"))
                .andExpect(jsonPath("$[0].age").value(20));
    }
}
