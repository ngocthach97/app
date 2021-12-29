package com.example.app.Controller;

import com.example.app.Model.Entity.Ward;
import com.example.app.Repository.Repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ward")
public class WardController {
    @Autowired
    private WardRepository wardRepository;

    @GetMapping("/get/{districtCode}")
    public ResponseEntity<List<Ward>> get(@PathVariable("districtCode") String districtCode) {
        List<Ward> list = wardRepository.findByDistrictCode(districtCode);
        return new ResponseEntity<List<Ward>>(list, HttpStatus.OK);
    }
}
