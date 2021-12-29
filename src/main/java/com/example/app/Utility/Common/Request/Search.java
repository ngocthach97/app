package com.example.app.Utility.Common.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Search implements Serializable {

    private  Long provinceCode;

    private  Long districtCode;

    private  Long wardCode;

}
