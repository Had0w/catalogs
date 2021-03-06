package com.kluev.catalogs.executors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class TableExecutorContainerTest {

    @Test
    void retrieveExecutor() {
        //given
        TableExecutorContainer tableExecutorContainer = new TableExecutorContainer(new EducYearExecutor(), new CitizenshipExecutor()
        , new SexExecutor());
        //when
        Executor executor = tableExecutorContainer.retrieveExecutor("EDUC_YEAR");
        //then
        Assertions.assertEquals(EducYearExecutor.class, executor.getClass());
    }
}