package com.fabiofrau.Project3.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public School toEntity(SchoolDto dto) {
        return School.builder()
                .name(dto.name())
                .build();
    }

    public SchoolDto toDto(School school) {
        return SchoolDto.builder()
                .name(school.getName())
                .build();
    }

}


