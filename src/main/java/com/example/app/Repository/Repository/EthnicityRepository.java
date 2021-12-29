package com.example.app.Repository.Repository;

import com.example.app.Model.Entity.Ethnicity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EthnicityRepository extends JpaRepository<Ethnicity, Long> {
}
