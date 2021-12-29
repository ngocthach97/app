package com.example.app.Repository.Repository;

import com.example.app.Model.Entity.District;
import com.example.app.Repository.RepositoryExt.DistrictRepositoryExt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, String>, DistrictRepositoryExt {
    District findByDistrictCode(String districtCode);

    List<District> findByProvinceCode(String provinceCode);
}
