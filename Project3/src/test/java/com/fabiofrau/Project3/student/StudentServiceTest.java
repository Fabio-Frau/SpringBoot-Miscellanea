package com.fabiofrau.Project3.student;

import com.fabiofrau.Project3.school.School;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shoudlSuccessfullySaveAStudent() {
        //Given
        StudentDto dto = new StudentDto(
                "Fabio",
                "Frau",
                "fabio@email.com",
                1);

        Student student = Student.builder()
                .firstName("Fabio")
                .lastName("Frau")
                .email("fabio@email.com")
                .age(32)
                .build();

        Student savedStudent = Student.builder()
                .firstName("Fabio")
                .lastName("Frau")
                .email("fabio@email.com")
                .age(32)
                .id(1)
                .build();

        StudentResponseDto expResponseDto = StudentResponseDto.builder()
                .firstName("Fabio")
                .lastName("Frau")
                .email("fabio@email.com")
                .build();

        //Mock the calls
        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(savedStudent);
        when(studentMapper.toResponseDto(savedStudent)).thenReturn(expResponseDto);

        //When
        StudentResponseDto responseDto = studentService.saveStudent(dto);

        //Then
        assertEquals(dto.firstName(), responseDto.firstName());
        assertEquals(dto.lastName(), responseDto.lastName());
        assertEquals(dto.email(), responseDto.email());

        verify(studentMapper, times(1)).toStudent(dto);
        verify(studentRepository, times(1)).save(student);
        verify(studentMapper, times(1)).toResponseDto(savedStudent);

    }

    @Test
    public void shoulReturnAllStudents() {

        //Given
        List<Student> students = new ArrayList<>();
        students.add(Student.builder()
                .firstName("Fabio")
                .lastName("Frau")
                .email("fabio@email.com")
                .age(32)
                .id(1)
                .build());

        //Mock the calls
        when(studentRepository.findAll()).thenReturn(students);
        when(studentMapper.toResponseDto(any(Student.class)))
                .thenReturn(StudentResponseDto.builder()
                        .firstName("Fabio")
                        .lastName("Frau")
                        .email("fabio@email.com")
                        .build());

        //When
        List<StudentResponseDto> responseDtos = studentService.findAllStudent();

        //Then
        assertEquals(students.size(), responseDtos.size());
        verify(studentRepository, times(1)).findAll();

    }

    @Test
    public void shouldReturnStudentById() {

        //Given
        Integer studentId = 1;
        Student student = Student.builder()
                .firstName("Fabio")
                .lastName("Frau")
                .email("fabio@email.com")
                .age(32)
                .build();

        //Mock the calls
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
        when(studentMapper.toResponseDto(any(Student.class)))
                .thenReturn(StudentResponseDto.builder()
                        .firstName("Fabio")
                        .lastName("Frau")
                        .email("fabio@email.com")
                        .build());

        //When
        StudentResponseDto dto = studentService.findStudentById(studentId);

        //Then
        assertEquals(student.getFirstName(), dto.firstName());
        assertEquals(student.getLastName(), dto.lastName());
        assertEquals(student.getEmail(), dto.email());

        verify(studentRepository, times(1)).findById(studentId);
    }

    @Test
    public void shouldFindStudentByname() {

        //Given
        String studentName = "Fabio";
        List<Student> students = new ArrayList<>();
        students.add(Student.builder()
                .firstName("Fabio")
                .lastName("Frau")
                .email("fabio@email.com")
                .age(32)
                .id(1)
                .build());

        //Mock the calls
        when(studentRepository.findAllByFirstNameContaining(studentName))
                .thenReturn(students);
        when(studentMapper.toResponseDto(any(Student.class)))
                .thenReturn(StudentResponseDto.builder()
                        .firstName("Fabio")
                        .lastName("Frau")
                        .email("fabio@email.com")
                        .build());

        //When
        List<StudentResponseDto> studentsDto = studentService.findStudentsByName(studentName);

        //Then
        assertEquals(students.size(), studentsDto.size());
        verify(studentRepository, times(1))
                .findAllByFirstNameContaining(studentName);
    }

}