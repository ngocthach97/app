package com.example.app.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Users")
    @SequenceGenerator(name = "seq_Users", sequenceName = "seq_Users", allocationSize = 1, initialValue = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    private int gender;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "gmail", nullable = false)
    private String gmail;

    @Column(name = "roles", nullable = false)
    private String roles;

    @Column(name = "nationCode", nullable = false)
    private String nationCode;

    @Column(name = "ethnicityCode", nullable = false)
    private String ethnicityCode;

    @Column(name = "provinceCode", nullable = false)
    private String provinceCode;

    @Column(name = "districtCode", nullable = false)
    private String districtCode;

    @Column(name = "wardCode", nullable = false)
    private String wardCode;


    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<Role> list = new ArrayList<>();


    @Column(name = "status")
    private int status;
}
