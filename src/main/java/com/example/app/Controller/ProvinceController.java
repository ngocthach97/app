package com.example.app.Controller;


import com.example.app.Model.Entity.Province;
import com.example.app.Repository.Repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/province")
@CrossOrigin(origins = "*")
public class ProvinceController {
    @Autowired
    private ProvinceRepository provinceRepository;

    @GetMapping("/getAll")
    public ResponseEntity<List<Province>> getAll() {
        List<Province> list = provinceRepository.findAll();
        return new ResponseEntity<List<Province>>(list, HttpStatus.OK);
    }
}
