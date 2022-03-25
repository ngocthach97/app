package com.example.app.Model.Mapper;

import com.example.app.Model.DTO.EthnicityDTO;
import com.example.app.Model.Entity.Ethnicity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface EthnicityMapper extends com.example.app.Model.Utility.Mapper<Ethnicity, EthnicityDTO> {
}
