package com.example.app.Configuration.Security;

import com.example.app.Model.Entity.Users;
import com.example.app.Repository.Repository.UserRepository;
import com.example.app.Service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users employee = new Users();
        try {
            employee = userRepository.findByUsername(username);
            return new CustomUserDetails(employee);
        } catch (NoResultException e) {
            logger.error("NoResultException:", e.getMessage());
        } finally {
            return new CustomUserDetails(employee);
        }
    }
}
