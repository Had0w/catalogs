package com.kluev.catalogs.executors;

import com.kluev.catalogs.entities.EducYear;
import com.kluev.catalogs.servises.EducYearServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.time.LocalDateTime;

@DataJpaTest
class EducYearExecutorTest {

    @MockBean
    EducYearServiceImpl educYearService;

    @SpyBean
    EducYearExecutor educYearExecutor;

    @Test
    void executeSaveTest() {
        //given
        String json = "{\n" +
                "\"id\" : 8,\n" +
                "\"title\" : \"2018-2019 Учебный год\",\n" +
                "\"year\" : 2018,\n" +
                "\"sdate\" : \"2020-08-30 20:00:00\",\n" +
                "\"edate\" : \"2020-08-30 20:00:00\"\n" +
                "}";
        String command = "Добавление";
        //when
        educYearExecutor.execute(command, json);
        //then
        Mockito.verify(educYearService).save(Mockito.any());
    }

    @Test
    void executeDeleteTest() {
        //given
        String json = "{\n" +
                "\"id\" : 8,\n" +
                "\"title\" : \"2018-2019 Учебный год\",\n" +
                "\"year\" : 2018,\n" +
                "\"sdate\" : \"2020-08-30 20:00:00\",\n" +
                "\"edate\" : \"2020-08-30 20:00:00\"\n" +
                "}";
        String command = "Удаление";
        //when
        educYearExecutor.execute(command, json);
        //then
        Mockito.verify(educYearService).delete(Mockito.any());
    }

    @Test
    void deserializationTest() {
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