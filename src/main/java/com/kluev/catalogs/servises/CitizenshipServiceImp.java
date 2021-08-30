package com.kluev.catalogs.servises;

import com.kluev.catalogs.entities.Citizenship;
import com.kluev.catalogs.repositories.CitizenshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CitizenshipServiceImp implements CitizenshipService {
    private CitizenshipRepository citizenshipRepository;

    @Autowired
    public void setCitizenshipRepository(CitizenshipRepository citizenshipRepository) {
        this.citizenshipRepository = citizenshipRepository;
    }


    @Override
    @Transactional
    public void save(Citizenship citizenship) {
        citizenshipRepository.save(citizenship);
    }

    @Override
    @Transactional
    public void delete(Citizenship citizenship) {
        citizenshipRepository.delete(citizenship);
    }
}
