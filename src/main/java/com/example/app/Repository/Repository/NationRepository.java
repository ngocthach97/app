package com.example.app.Repository.Repository;

import com.example.app.Model.Entity.Nation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationRepository extends JpaRepository<Nation, Long> {
    Nation findByNationCode(String nationCode);
}
