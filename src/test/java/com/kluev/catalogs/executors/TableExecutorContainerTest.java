package com.kluev.catalogs.executors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class TableExecutorContainerTest {

    @Test
    void retrieveExecutor() {
        //given
        TableExecutorContainer tableExecutorContainer = new TableExecutorContainer(new EducYearExecutor(), new CitizenshipExecutor());
        //when
        Executor executor = tableExecutorContainer.retrieveExecutor("EDUC_YEAR");
        //then
        Assertions.assertEquals(EducYearExecutor.class, executor.getClass());
    }
}