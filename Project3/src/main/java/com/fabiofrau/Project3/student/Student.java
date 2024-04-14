package com.fabiofrau.Project3.student;


import com.fabiofrau.Project3.school.School;
import com.fabiofrau.Project3.studentProfile.StudentProfile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "T_STUDENT")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "c_fname", length = 20)
    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private int age;

    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )
    @JsonBackReference
    private School school;



}
