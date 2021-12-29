package com.example.app.Service.Service;

import com.example.app.Model.DTO.UsersDTO;
import com.example.app.Model.Entity.Users;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface UserService {

    List<Users> getAllUsers();

    List<UsersDTO> getAllUsersDTO();

    UsersDTO postUsersDTO(MultipartFile file);
}
