package com.fabiofrau.Project3.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDto dto = new StudentDto(
                "Fabio",
                "Frau",
                "fabio@email.com",
                1);

        Student student = mapper.toStudent(dto);

        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void shouldMapStudentToStudentResponseDto() {

        //Given
        Student student = Student.builder()
                .firstName("Fabio")
                .lastName("Frau")
                .email("fabio@email.com")
                .age(32)
                .build();

        //When
        StudentResponseDto response = mapper.toResponseDto(student);

        //Then
        assertEquals(student.getFirstName(), response.firstName());
        assertEquals(student.getLastName(), response.lastName());
        assertEquals(student.getEmail(), response.email());
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenStudentDtoIsNull() {
        Throwable thr = assertThrows(NullPointerException.class,
                () -> mapper.toStudent(null));

        assertEquals("The student dto should not be null", thr.getMessage());

    }

}