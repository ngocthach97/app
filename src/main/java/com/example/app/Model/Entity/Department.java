package com.example.app.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "department")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {
    @Id
    @Column(name = "departmentCode", length = 10)
    private Long departmentCode;

    @Column(name = "departmentName", length = 50)
    private String departmentName;

    @Column(name = "gmail", length = 50)
    private String gmail;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "fax", length = 50)
    private String fax;

    @Column(name = "provinceCode", nullable = false)
    private Long provinceCode;

    @Column(name = "districtCode", nullable = false)
    private Long districtCode;

    @Column(name = "wardCode", nullable = false)
    private Long wardCode;

    @Column(name = "status")
    private int status;
}
