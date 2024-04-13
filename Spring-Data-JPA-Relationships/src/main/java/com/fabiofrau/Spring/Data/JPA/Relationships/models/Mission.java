package com.fabiofrau.Spring.Data.JPA.Relationships.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Mission {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer duration;

    @ManyToMany(mappedBy = "missions")
    private List<Employee> employees;

}
