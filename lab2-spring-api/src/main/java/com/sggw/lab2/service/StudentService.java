package com.sggw.lab2.service;

import com.sggw.lab2.dto.StudentDto;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private static final String[] FIRST_NAMES = {
        "Anna",
        "Bartek",
        "Celina",
        "Dawid",
        "Ela",
        "Filip",
        "Gosia",
        "Hubert",
    };
    private static final String[] LAST_NAMES = {
        "Nowak",
        "Kowalski",
        "Wiśniewska",
        "Wójcik",
        "Mazur",
        "Krawczyk",
    };

    public List<StudentDto> getStudents() {
        List<StudentDto> result = new ArrayList<>();
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i = 0; i < 5; i++) {
            String name =
                FIRST_NAMES[random.nextInt(FIRST_NAMES.length)] +
                " " +
                LAST_NAMES[random.nextInt(LAST_NAMES.length)];
            int age = random.nextInt(18, 31);
            result.add(new StudentDto(UUID.randomUUID().toString(), name, age));
        }

        return result;
    }
}
