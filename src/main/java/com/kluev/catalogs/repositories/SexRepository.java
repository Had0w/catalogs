package com.kluev.catalogs.repositories;

import com.kluev.catalogs.entities.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SexRepository extends JpaRepository<Sex, Long> {
}
