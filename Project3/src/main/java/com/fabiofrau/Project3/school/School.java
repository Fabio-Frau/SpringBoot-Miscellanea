package com.fabiofrau.Project3.school;

import com.fabiofrau.Project3.student.Student;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "school")
public class School {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @OneToMany(
            mappedBy = "school"
    )
    @JsonManagedReference
    private List<Student> students;



}
