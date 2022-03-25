package com.example.app.Model.Mapper;

import com.example.app.Model.DTO.WardDTO;
import com.example.app.Model.Entity.Ward;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface WardMapper extends com.example.app.Model.Utility.Mapper<Ward, WardDTO> {
}
