package com.example.app.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Privilege")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Privilege {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String namePrivilege;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private int status;
}
