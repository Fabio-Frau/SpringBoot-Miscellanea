package com.fabiofrau.Project3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface SchoolRepository extends JpaRepository<School,Integer> {
}
