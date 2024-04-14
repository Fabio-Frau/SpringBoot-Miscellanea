package com.fabiofrau.Project3;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/students")
    public StudentResponseDto saveStudent(@RequestBody StudentDto studentDto) {
        return studentService.saveStudent(studentDto);
    }

    @GetMapping("/students")
    public List<Student> findAllStudent() {
        return studentService.findAllStudent();
    }

    @GetMapping("/students/{student-id}")
    public Student findStudentById(@PathVariable("student-id") Integer id) {
        return studentService.findStudentById(id);
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentsByName(@PathVariable("student-name") String firstName) {
        return studentService.findStudentsByName(firstName);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("student-id") Integer id) {
        studentService.deleteById(id);
    }



}
