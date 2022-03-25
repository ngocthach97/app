package com.example.app.Repository.Repository;

import com.example.app.Model.DTO.UsersDTO;
import com.example.app.Model.Entity.Users;
import com.example.app.Repository.RepositoryExt.UserRepositoryExt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>, UserRepositoryExt {

    Users findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByGmail(String gmail);

    boolean existsByPhone(String gmail);

    Users save(Users users);

}
