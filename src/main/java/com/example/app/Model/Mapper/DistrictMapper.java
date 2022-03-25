package com.example.app.Model.Mapper;

import com.example.app.Model.DTO.DistrictDTO;
import com.example.app.Model.Entity.District;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface DistrictMapper extends com.example.app.Model.Utility.Mapper<District, DistrictDTO> {
}