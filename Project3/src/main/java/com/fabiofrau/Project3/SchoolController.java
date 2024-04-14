package com.fabiofrau.Project3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolRepository schoolRepository;

    @PostMapping("/schools")
    public SchoolDto create(@RequestBody SchoolDto school) {
        return schoolRepository.save(school.toEntity()).toDto();
    }

    @GetMapping("/schools")
    public List<SchoolDto> findAll() {
        return schoolRepository.findAll().stream().map(School::toDto).toList();
    }


}
