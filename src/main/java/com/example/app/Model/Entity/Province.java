package com.example.app.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "province")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Province implements Serializable {
    @Id
    @Column(name = "provinceCode")
    private String provinceCode;

    @Column(name = "name")
    private String nameProvince;

    @Column(name = "type")
    private String type;

//    @Column(name = "status")
//    private int status;
}
