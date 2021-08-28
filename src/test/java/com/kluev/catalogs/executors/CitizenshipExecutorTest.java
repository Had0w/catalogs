package com.kluev.catalogs.executors;

import com.kluev.catalogs.entities.Citizenship;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitizenshipExecutorTest {

    @Test
    void execute() {
    }

    @Test
    void deserialization() {
        //given
        String json = "{\n" +
                "\"id\" : 9,\n" +
                "\"code\" : \"PTZ\",\n" +
                "\"title\" : \"blablabla\",\n" +
                "\"updatedAt\" : \"2021-08-30 20:00:00\"\n" +
                "}";
        Citizenship expexted = new Citizenship();
        expexted.setId(9);
        expexted.setCode("PTZ");
        expexted.setTitle("blablabla");
        expexted.setUpdatedAt(LocalDateTime.of(2021, 8, 30, 20, 0));
        //when
        Citizenship given = new CitizenshipExecutor().deserialization(json);
        //then
        Assertions.assertEquals(expexted.getId(), given.getId());
        Assertions.assertEquals(expexted.getCode(), given.getCode());
        Assertions.assertEquals(expexted.getTitle(), given.getTitle());
        Assertions.assertEquals(expexted.getUpdatedAt(), given.getUpdatedAt());
    }
}