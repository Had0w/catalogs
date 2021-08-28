package com.kluev.catalogs.executors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TableExecutorContainerTest {

    @Test
    void retrieveExecutor() {
        //given
        TableExecutorContainer tableExecutorContainer = new TableExecutorContainer();
        //when
        Executor executor = tableExecutorContainer.retrieveExecutor("EDUC_YEAR");
        //then
        Assertions.assertEquals(EducYearExecutor.class, executor.getClass());
    }
}