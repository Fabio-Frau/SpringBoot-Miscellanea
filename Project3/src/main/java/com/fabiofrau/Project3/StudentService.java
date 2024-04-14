package com.fabiofrau.Project3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    public StudentResponseDto saveStudent(StudentDto dto) {
        Student student = studentMapper.toStudent(dto);

        return studentMapper.toResponseDto(studentRepository.save(student));
    }

    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }


    public Student findStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElse(new Student());
    }

    public List<Student> findStudentsByName(String firstName) {
        return studentRepository.findAllByFirstNameContaining(firstName);
    }

    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }
}
