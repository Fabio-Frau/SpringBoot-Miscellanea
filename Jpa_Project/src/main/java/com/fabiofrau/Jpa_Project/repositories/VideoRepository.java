package com.fabiofrau.Jpa_Project.repositories;

import com.fabiofrau.Jpa_Project.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
}
