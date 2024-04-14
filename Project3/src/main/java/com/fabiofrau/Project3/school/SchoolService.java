package com.fabiofrau.Project3.school;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;

    private final SchoolMapper schoolMapper;

    public SchoolDto create(SchoolDto school) {
        School schoolEntity = schoolMapper.toEntity(school);
        School savedSchool = schoolRepository.save(schoolEntity);
        return schoolMapper.toDto(savedSchool);
    }

    public List<SchoolDto> findAll() {
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toDto)
                .toList();
    }


}
