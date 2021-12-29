package com.example.app.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity(name = "userLogin")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserLogin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_UserLogin")
    @SequenceGenerator(name = "seq_UserLogin", sequenceName = "seq_UserLogin", allocationSize = 1, initialValue = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "ip", nullable = false)
    private String ip;

    @Column(name = "dateLogin", nullable = false)
    private Instant dateLogin;

    @Column(name = "status", nullable = false)
    private boolean status;
}
