package com.example.app.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Ward")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ward implements Serializable {
    @Id
    @Column(name = "wardCode")
    private String wardCode;

    @Column(name = "name")
    private String nameWard;

    @Column(name = "type")
    private String type;

    @Column(name = "districtCode")
    private String districtCode;

    @Column(name = "status")
    private int status;

    @Column(name = "createDate")
    private Date createDate;
}
