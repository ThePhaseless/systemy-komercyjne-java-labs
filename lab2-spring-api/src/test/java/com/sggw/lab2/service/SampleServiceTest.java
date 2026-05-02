package com.sggw.lab2.service;

import com.sggw.lab2.dto.SampleDto;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SampleServiceTest {
    @Test
    void processReturnsFiveDtosWithUuidIds() {
        SampleService service = new SampleService();

        List<SampleDto> result = service.process();

        assertEquals(5, result.size());
        for (SampleDto dto : result) {
            assertDoesNotThrow(() -> UUID.fromString(dto.getId()));
            assertFalse(dto.getName().isBlank());
            assertTrue(dto.getAge() >= 18);
        }
    }
}
