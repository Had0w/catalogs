package com.kluev.catalogs.executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;

@Component
public class TableExecutorContainer {
    private HashMap<String, Executor> tables = new HashMap<>();

    @Autowired
    private EducYearExecutor educYearExecutor;

    public TableExecutorContainer() {
        tables.put("EDUC_YEAR", educYearExecutor);
    }

    public Executor retrieveExecutor(String tableName) {
        return tables.get(tableName);
    }
}
