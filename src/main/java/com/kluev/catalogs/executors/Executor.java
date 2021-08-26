package com.kluev.catalogs.executors;

import com.kluev.catalogs.entities.EducYear;
import org.springframework.stereotype.Component;

public interface Executor {
    // Добавить полиморфизм
    void execute(EducYear educYear);
}
