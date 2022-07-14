package com.example.app.Model.Mapper;

import com.example.app.Model.DTO.ProvinceDTO;
import com.example.app.Model.Entity.Province;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ProvinceMapper extends com.example.app.Model.Utility.Mapper<Province, ProvinceDTO> {
}
