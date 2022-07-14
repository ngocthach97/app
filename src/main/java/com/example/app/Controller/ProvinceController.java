package com.example.app.Controller;


import com.example.app.Model.DTO.ProvinceDTO;
import com.example.app.Model.Entity.Province;
import com.example.app.Repository.Repository.ProvinceRepository;
import com.example.app.Utility.Common.Request.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/getPaging")
    public ResponseEntity<Object> getPaging(@RequestBody Page page) {
        List<ProvinceDTO> list = provinceRepository.searchProvincePaging(page);
        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }
}
