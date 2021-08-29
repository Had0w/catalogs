package com.kluev.catalogs.repositories;

import com.kluev.catalogs.entities.EducYear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class EducYearRepositoryTest {

    @Autowired
    private EducYearRepository underTest;

    @BeforeEach
    void setUp() {
        EducYear educYear1 = new EducYear();
        educYear1.setId(1);
        educYear1.setTitle("2020");
        EducYear educYear2 = new EducYear();
        educYear2.setId(2);
        educYear2.setTitle("2021");
        underTest.save(educYear1);
        underTest.save(educYear2);
    }

    @Test
    public void getUserByIdTest() {
        //when
        EducYear actual = underTest.getById(1L);
        //then
        Assertions.assertEquals("2020", actual.getTitle());
    }

    @Test
    public void updateTest() {
        //given
        EducYear educYear = new EducYear();
        educYear.setId(2);
        educYear.setTitle("2022");
        //when
        underTest.save(educYear);
        //then
        EducYear actual = underTest.getById(2L);
        Assertions.assertEquals("2022", educYear.getTitle());
    }
}