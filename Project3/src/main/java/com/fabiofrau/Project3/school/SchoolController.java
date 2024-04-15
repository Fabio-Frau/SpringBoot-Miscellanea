package com.fabiofrau.Project3.school;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping("/schools")
    public SchoolDto create(@RequestBody SchoolDto school) {
        return schoolService.create(school);
    }

    @GetMapping("/schools")
    public List<SchoolDto> findAll() {
        return schoolService.findAll();
    }


}
