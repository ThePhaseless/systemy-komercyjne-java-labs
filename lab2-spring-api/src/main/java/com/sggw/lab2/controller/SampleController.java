package com.sggw.lab2.controller;

import com.sggw.lab2.dto.SampleDto;
import com.sggw.lab2.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/samples")
public class SampleController {
    private final SampleService sampleService;

    @Autowired
    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/hello")
    public List<SampleDto> hello() {
        return sampleService.process();
    }
}
