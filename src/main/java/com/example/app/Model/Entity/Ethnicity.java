package com.example.app.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "ethnicity")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ethnicity implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "ethnicityCode")
    private String ethnicityCode;

    @Column(name = "ethnicityName")
    private String name;

    @Column(name = "status")
    private int status;
}
