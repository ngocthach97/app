package com.example.app.Controller;

import com.example.app.Model.Entity.District;
import com.example.app.Repository.Repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/district")
public class DistrictController {

    @Autowired
    private DistrictRepository districtRepository;

    @GetMapping("/get/{provinceCode}")
    public ResponseEntity<List<District>> getByProvinceCode(@PathVariable("provinceCode") String provinceCode) {
        List<District> list = districtRepository.findByProvinceCode(provinceCode);
        return new ResponseEntity<List<District>>(list, HttpStatus.OK);
    }

}
