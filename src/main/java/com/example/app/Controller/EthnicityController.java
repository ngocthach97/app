package com.example.app.Controller;

import com.example.app.Model.Entity.Ethnicity;
import com.example.app.Repository.Repository.EthnicityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ethnicity")
public class EthnicityController {
    @Autowired
    private EthnicityRepository ethnicityRepository;

    @GetMapping("/getAll")
    public ResponseEntity<List<Ethnicity>> getAll() {
        List<Ethnicity> list = ethnicityRepository.findAll();
        return new ResponseEntity<List<Ethnicity>>(list, HttpStatus.OK);
    }
}
