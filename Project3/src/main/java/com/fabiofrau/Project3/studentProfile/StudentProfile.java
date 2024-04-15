package com.fabiofrau.Project3.studentProfile;

import com.fabiofrau.Project3.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentProfile {

    @Id
    @GeneratedValue
    private Integer id;

    private String bio;

    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;
}
