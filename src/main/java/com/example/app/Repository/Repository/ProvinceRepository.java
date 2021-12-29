package com.example.app.Repository.Repository;

import com.example.app.Model.Entity.Province;
import com.example.app.Repository.RepositoryExt.ProvinceRepositoryExt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, String>, ProvinceRepositoryExt {
    Province findByProvinceCode(String provinceCode);
}
