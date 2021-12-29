package com.example.app.Repository.Repository;

import com.example.app.Model.Entity.Ward;
import com.example.app.Repository.RepositoryExt.WardRepositoryExt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WardRepository extends JpaRepository<Ward, String>, WardRepositoryExt {
    Ward findByWardCode(String wardCode);

    List<Ward> findByDistrictCode(String districtCode);
}
