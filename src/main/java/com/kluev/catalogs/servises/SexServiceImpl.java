package com.kluev.catalogs.servises;

import com.kluev.catalogs.entities.Sex;
import com.kluev.catalogs.repositories.SexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SexServiceImpl implements SexService {
    private SexRepository sexRepository;

    @Autowired
    public void setSexRepository(SexRepository sexRepository) {
        this.sexRepository = sexRepository;
    }

    @Override
    @Transactional
    public void save(Sex sex) {
        sexRepository.save(sex);
    }

    @Override
    @Transactional
    public void delete(Sex sex) {
        sexRepository.delete(sex);
    }
}
