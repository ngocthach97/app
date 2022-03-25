package com.example.app.Controller;

//import com.example.app.Configuration.Security.CustomUserDetails;
//import com.example.app.Configuration.Security.Jwt.JwtUtilities;
import com.example.app.Model.DTO.UsersDTO;
import com.example.app.Model.Entity.UserLogin;
import com.example.app.Model.Entity.Users;
import com.example.app.Repository.Repository.UserLoginRepository;
import com.example.app.Repository.Repository.UserRepository;
import com.example.app.Service.Service.UserService;
import com.example.app.Utility.Common.Request.LoginRequest;
import com.example.app.Utility.Common.Request.Search;
import com.example.app.Utility.Common.Response.LoginResponse;
import com.example.app.Utility.Common.Response.NotificationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserLoginRepository userLoginRepository;

//    @Autowired
//    private AuthenticationManager authenticationManager;
//
    @Autowired
    UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder encoder;
//
//    @Autowired
//    JwtUtilities jwtUtils;

    @Autowired
    UserService userService;

    // Signin
//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticateUser(HttpServletRequest request,
//                                              HttpServletResponse response,
//                                              @RequestBody LoginRequest loginRequest) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            String jwt = jwtUtils.CreateToken(authentication);
//            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
//            UserLogin loginLog = UserLogin.builder()
//                    .username(request.getUserPrincipal().getName())
//                    .ip(request.getRemoteAddr())
//                    .dateLogin(Instant.now())
//                    .status(true)
//                    .build();
//            userLoginRepository.save(loginLog);
//            return ResponseEntity.ok(new LoginResponse(
//                    jwt,
//                    userDetails.getUsers().getId(),
//                    userDetails.getUsers().getUsername(),
//                    userDetails.getUsers().getRoles()));
//        } catch (Exception e) {
//            UserLogin loginLog = UserLogin.builder()
//                    .username(loginRequest.getUsername())
//                    .ip(request.getRemoteAddr())
//                    .dateLogin(Instant.now())
//                    .status(false)
//                    .build();
//            userLoginRepository.save(loginLog);
//            return ResponseEntity.badRequest().body(NotificationResponse.builder()
//                    .message("Login failed !")
//                    .status(false)
//                    .build()
//            );
//        }
//    }
//
//    // Signup
//    @PostMapping("/signup")
//    public ResponseEntity<NotificationResponse> registerUser(@RequestBody Users user) {
//        if (userRepository.existsByUsername(user.getUsername())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(NotificationResponse.builder()
//                            .message("Username is already taken !")
//                            .status(false)
//                            .build()
//                    );
//        }
//        if (userRepository.existsByGmail(user.getGmail())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(NotificationResponse.builder()
//                            .message("Email is already in use !")
//                            .status(false)
//                            .build()
//                    );
//        }
//        user.setPassword(encoder.encode(user.getPassword()));
//        userRepository.save(user);
//        return ResponseEntity.ok(NotificationResponse.builder()
//                .message("Registered Successfully !")
//                .status(true)
//                .build()
//        );
//    }

    @GetMapping("/get")
    public ResponseEntity<List<UsersDTO>> get() {
        List<UsersDTO> list = userService.getAllUsersDTO();
        return new ResponseEntity<List<UsersDTO>>(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UsersDTO> create(@RequestBody Users user) {
        UsersDTO usersDTO = userService.createUser(user);
        return new ResponseEntity<UsersDTO>(usersDTO, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Users>> getList(Search search, Pageable pageable) {
        List<Users> list = userRepository.search(search, pageable);
        return new ResponseEntity<List<Users>>(list, HttpStatus.OK);
    }

    @PostMapping("/importexcel")
    public ResponseEntity<?> importFileExcel(MultipartFile file) {
        NotificationResponse notificationResponse = userService.importUsers(file);
        return ResponseEntity.ok().body(notificationResponse);
    }

    @GetMapping("/exportexcel")
    public void exportFileExcel(HttpServletResponse response) {
        userService.exportUsers(response);
    }
}
