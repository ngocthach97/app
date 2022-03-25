package com.example.app.Service.ServiceImpl;


import com.example.app.Model.Entity.Province;
import com.example.app.Repository.Repository.ProvinceRepository;
import com.example.app.Service.Service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;
    @Override
    public List<Province> getAllProvince() {
        return provinceRepository.search();
    }
}
