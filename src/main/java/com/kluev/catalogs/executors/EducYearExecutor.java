package com.kluev.catalogs.executors;

import com.kluev.catalogs.entities.EducYear;
import com.kluev.catalogs.repositories.EducYearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EducYearExecutor implements Executor {
    private EducYearRepository educYearRepository;

    @Autowired
    public void setEducYearRepository(EducYearRepository educYearRepository) {
        this.educYearRepository = educYearRepository;
    }

    @Override
    public void execute(EducYear educYear) {
        educYearRepository.save(educYear);
    }
}
