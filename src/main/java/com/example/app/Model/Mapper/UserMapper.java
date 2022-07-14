package com.example.app.Model.Mapper;

import com.example.app.Model.DTO.UsersDTO;
import com.example.app.Model.Entity.Users;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper extends com.example.app.Model.Utility.Mapper<Users, UsersDTO> {
}
