package com.example.app.Model.Mapper;

import com.example.app.Model.DTO.NationDTO;
import com.example.app.Model.Entity.Nation;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface NationMapper extends com.example.app.Model.Utility.Mapper<Nation, NationDTO> {
}
