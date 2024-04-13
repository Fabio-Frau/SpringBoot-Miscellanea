package com.fabiofrau.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fabiofrau.demo.domain.User;
public interface UserRepository extends JpaRepository<User, Integer>
{
}