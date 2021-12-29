package com.example.app.Controller;

import com.example.app.Configuration.Security.CustomUserDetails;
import com.example.app.Configuration.Security.Jwt.JwtUtilities;
import com.example.app.Model.DTO.UsersDTO;
import com.example.app.Model.Entity.UserLogin;
import com.example.app.Model.Entity.Users;
import com.example.app.Repository.Repository.UserLoginRepository;
import com.example.app.Repository.Repository.UserRepository;
import com.example.app.Service.Service.UserService;
import com.example.app.Utility.Common.Request.LoginRequest;
import com.example.app.Utility.Common.Request.Search;
import com.example.app.Utility.Common.Response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    JwtUtilities jwtUtils;

    @Autowired
    UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(HttpServletRequest request,
                                              HttpServletResponse response,
                                              @RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.CreateToken(authentication);
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            UserLogin loginLog = UserLogin.builder()
                    .username(request.getUserPrincipal().getName())
                    .ip(request.getRemoteAddr())
                    .dateLogin(Instant.now())
                    .status(true)
                    .build();
            userLoginRepository.save(loginLog);
            return ResponseEntity.ok(new LoginResponse(
                    jwt,
                    userDetails.getUsers().getId(),
                    userDetails.getUsers().getUsername(),
                    userDetails.getUsers().getRoles()));
        } catch (Exception e) {
            UserLogin loginLog = UserLogin.builder()
                    .username(loginRequest.getUsername())
                    .ip(request.getRemoteAddr())
                    .dateLogin(Instant.now())
                    .status(false)
                    .build();
            userLoginRepository.save(loginLog);
            return new ResponseEntity("Error: Login failed !", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody Users user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken !");
        }
        if (userRepository.existsByGmail(user.getGmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Email is already in use !");
        }
        user.setPassword(encoder.encode(user.getPassword()));

        userRepository.save(user);
        return ResponseEntity.ok("Registered Successfully !");
    }

    @GetMapping("/get")
    public ResponseEntity<List<UsersDTO>> get() {
        List<UsersDTO> list = userService.getAllUsersDTO();
        return new ResponseEntity<List<UsersDTO>>(list, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Users>> getList(Search search, Pageable pageable) {
        List<Users> list = userRepository.search(search, pageable);
        return new ResponseEntity<List<Users>>(list, HttpStatus.OK);
    }


    @PostMapping("/addexcel")
    public ResponseEntity<String> postFileExcel(MultipartFile file) {
        return new ResponseEntity<String>("list", HttpStatus.OK);
    }
}
