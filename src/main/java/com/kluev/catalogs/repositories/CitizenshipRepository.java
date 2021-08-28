package com.kluev.catalogs.repositories;

import com.kluev.catalogs.entities.Citizenship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenshipRepository extends JpaRepository<Citizenship, Long> {
}
