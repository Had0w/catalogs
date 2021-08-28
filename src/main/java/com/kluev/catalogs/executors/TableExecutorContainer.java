package com.kluev.catalogs.executors;

import com.kluev.catalogs.servises.CitizenshipServiceImp;
import com.kluev.catalogs.servises.EducYearServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.orm.hibernate5.SpringBeanContainer;
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
