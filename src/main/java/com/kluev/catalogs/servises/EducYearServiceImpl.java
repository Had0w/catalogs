package com.kluev.catalogs.servises;

import com.kluev.catalogs.entities.EducYear;
import com.kluev.catalogs.repositories.EducYearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducYearServiceImpl implements EducYearService {
    private EducYearRepository educYearRepository;

    @Autowired
    public void setEducYearRepository(EducYearRepository educYearRepository) {
        this.educYearRepository = educYearRepository;
    }

    @Override
    public void save(EducYear educYear) {
        educYearRepository.save(educYear);
    }

    @Override
    public void delete(EducYear educYear) { educYearRepository.delete(educYear);}
}
