package com.kluev.catalogs.servises;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RequestServiceTest {

    @Test
    void parseRequestTest() {
        //given
        String request = "Добавление GENDER: {\n" +
                "id : 8,\n" +
                "title : \"2018-2019 Учебный год\",\n" +
                "year : 2018,\n" +
                "sdate : \"2020-08-30 20:00:00.000000\",\n" +
                "edate : \"2020-08-30 20:00:00.000000\"\n" +
                "}";
        //when
        String[] strings = RequestService.parseRequest(request);
        //then
        Assertions.assertEquals("Добавление", strings[0]);
        Assertions.assertEquals("GENDER", strings[1]);
        Assertions.assertEquals("{\n" +
                "id : 8,\n" +
                "title : \"2018-2019 Учебный год\",\n" +
                "year : 2018,\n" +
                "sdate : \"2020-08-30 20:00:00.000000\",\n" +
                "edate : \"2020-08-30 20:00:00.000000\"\n" +
                "}", strings[2]);
    }
}