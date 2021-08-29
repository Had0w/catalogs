package com.kluev.catalogs.executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;

@Component
public class TableExecutorContainer {
    private HashMap<String, Executor> tables = new HashMap<>();

    @Autowired
    public TableExecutorContainer(EducYearExecutor educYearExecutor, CitizenshipExecutor citizenshipExecutor) {
        tables.put(Tables.EDUC_YEAR.getTableName(), educYearExecutor);
        tables.put(Tables.CITIZENSHIP.getTableName(), citizenshipExecutor);
    }

    public Executor retrieveExecutor(String tableName) {
        return tables.get(tableName);
    }
}
