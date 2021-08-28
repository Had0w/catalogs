package com.kluev.catalogs.executors;

import com.kluev.catalogs.servises.CitizenshipServiceImp;
import com.kluev.catalogs.servises.EducYearServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;

@Component
public class TableExecutorContainer {
    private HashMap<String, Executor> tables = new HashMap<>();

    public TableExecutorContainer() {
        tables.put(Tables.EDUC_YEAR.getTableName(), new EducYearExecutor());
        tables.put(Tables.CITIZENSHIP.getTableName(), new CitizenshipExecutor());
    }

    public Executor retrieveExecutor(String tableName) {
        return tables.get(tableName);
    }
}
