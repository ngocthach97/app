package com.example.app.Controller;


import com.example.app.Model.Entity.Nation;
import com.example.app.Repository.Repository.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nation")
public class NationController {
    @Autowired
    private NationRepository nationRepository;

    @GetMapping("/getAll")
    public ResponseEntity<List<Nation>> getAll() {
        List<Nation> list = nationRepository.findAll();
        return new ResponseEntity<List<Nation>>(list, HttpStatus.OK);
    }
}
