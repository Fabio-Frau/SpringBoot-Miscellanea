package com.fabiofrau.Project3.student;

import com.fabiofrau.Project3.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto dto) {

        if(dto == null) {
            throw new NullPointerException("The student dto should not be null");
        }

        return Student.builder()
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .email(dto.email())
                .school(School.builder().id(dto.schoolId()).build())
                .build();
    }

    public StudentResponseDto toResponseDto(Student entity) {
        return StudentResponseDto.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .build();
    }

}
