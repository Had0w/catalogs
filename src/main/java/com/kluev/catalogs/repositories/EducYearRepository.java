package com.kluev.catalogs.repositories;

import com.kluev.catalogs.entities.EducYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducYearRepository extends JpaRepository<EducYear, Long> {
}
