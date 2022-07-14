package com.example.app.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "district")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class District implements Serializable {
    @Id
    @Column(name = "districtCode", length = 10)
    private String districtCode;

    @Column(name = "name", length = 50)
    private String nameDistrict;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "provinceCode", length = 50)
    private String provinceCode;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "status")
    private int status;
}
