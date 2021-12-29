package com.example.app.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "nation")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Nation implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nationCode")
    private String nationCode;

    @Column(name = "nationName")
    private String name;

    @Column(name = "status")
    private int status;
}
