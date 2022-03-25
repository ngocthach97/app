package com.example.app.Service.Service;

import com.example.app.Model.DTO.UsersDTO;
import com.example.app.Model.Entity.Users;
import com.example.app.Utility.Common.Response.NotificationResponse;
import org.apache.catalina.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


public interface UserService {

    List<Users> getAllUsers();

    List<UsersDTO> getAllUsersDTO();

    NotificationResponse importUsers(MultipartFile file);

    void exportUsers(HttpServletResponse response);

    UsersDTO createUser(Users users);
}
