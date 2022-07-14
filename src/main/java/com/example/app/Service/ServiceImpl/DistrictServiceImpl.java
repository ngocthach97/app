package com.example.app.Service.ServiceImpl;

import com.example.app.Model.Entity.District;
import com.example.app.Repository.Repository.DistrictRepository;
import com.example.app.Service.Service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public List<District> getAllDistrict() {
        return districtRepository.search();
    }
}
