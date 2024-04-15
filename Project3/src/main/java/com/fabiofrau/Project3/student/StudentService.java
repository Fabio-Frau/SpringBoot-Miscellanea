package com.fabiofrau.Project3.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public List<StudentResponseDto> findAllStudent() {
        return studentRepository.findAll().stream().map(studentMapper::toResponseDto).toList();
    }


    public StudentResponseDto findStudentById(Integer id) {
        return studentRepository.findById(id).map(studentMapper::toResponseDto)
                .orElse(null);
    }

    public List<StudentResponseDto> findStudentsByName(String firstName) {
        return studentRepository.findAllByFirstNameContaining(firstName)
                .stream()
                .map(studentMapper::toResponseDto)
                .toList();
    }

    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }
}
