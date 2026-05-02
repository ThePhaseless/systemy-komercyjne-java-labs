package com.sggw.lab2.service;

import com.sggw.lab2.dto.SampleDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SampleService {
    public List<SampleDto> process() {
        String[] names = {"Anna", "Bartek", "Celina", "Dawid", "Ela"};
        int[] ages = {20, 21, 22, 23, 24};
        List<SampleDto> result = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            result.add(new SampleDto(UUID.randomUUID().toString(), names[i], ages[i]));
        }

        return result;
    }
}
