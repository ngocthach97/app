package com.example.app.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Role")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String nameRole;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "privilege_role",
            joinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Privilege> list = new ArrayList<>();

    @Column(name = "status")
    private int status;
}
