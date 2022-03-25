package com.example.app.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProvinceDTO {
    private String provinceCode;
    private String nameProvince;
}
