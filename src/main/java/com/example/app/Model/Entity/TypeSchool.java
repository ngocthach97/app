package com.example.app.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "typeSchool")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TypeSchool {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nameType")
    private String nameTypeSchool;

    @Column(name = "status")
    private String status;
}
