package com.kluev.catalogs.executors;

import com.kluev.catalogs.entities.EducYear;
import com.kluev.catalogs.servises.EducYearServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class EducYearExecutorTest {

    @Mock
    EducYearServiceImpl educYearService;

    @Test
    void execute() {

    }

    @Test
    void deserialization() {
        //given
        String json = "{\n" +
                "\"id\" : 8,\n" +
                "\"title\" : \"2018-2019 Учебный год\",\n" +
                "\"year\" : 2018,\n" +
                "\"sdate\" : \"2020-08-30 20:00:00\",\n" +
                "\"edate\" : \"2020-08-30 20:00:00\"\n" +
                "}";
        EducYear expected = new EducYear();
        expected.setId(8);
        expected.setTitle("2018-2019 Учебный год");
        expected.setYear(2018);
        expected.setEDate(LocalDateTime.of(2020, 8, 30, 20, 0, 0));
        expected.setSDate(LocalDateTime.of(2020, 8, 30, 20, 0, 0));
        //when
        EducYear actual = new EducYearExecutor().deserialization(json);
        //then
        Assertions.assertEquals(expected.getId(), actual.getId());
        Assertions.assertEquals(expected.getTitle(), actual.getTitle());
        Assertions.assertEquals(expected.getEDate(), expected.getEDate());
        Assertions.assertEquals(expected.getSDate(), actual.getSDate());
        Assertions.assertEquals(expected.getYear(), actual.getYear());
    }
}