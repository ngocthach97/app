package com.example.app.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "school")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class School {
    @Id
    @Column(name = "schoolCode")
    private String schoolCode;

    @Column(name = "nameSchool")
    private String nameSchool;

    @Column(name = "typeEducation")
    private String typeEducation;

    @Column(name = "typeSchool")
    private Long typeSchool;

    @Column(name = "departmentCode")
    private Long departmentCode;

    @Column(name = "gmail", length = 50)
    private String gmail;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "fax", length = 50)
    private String fax;

    @Column(name = "website", length = 50)
    private String website;

    @Column(name = "provinceCode", nullable = false)
    private Long provinceCode;

    @Column(name = "districtCode", nullable = false)
    private Long districtCode;

    @Column(name = "wardCode", nullable = false)
    private Long wardCode;

    @Column(name = "status")
    private int status;
}
