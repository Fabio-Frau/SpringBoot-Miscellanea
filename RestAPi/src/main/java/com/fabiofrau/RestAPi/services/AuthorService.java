package com.fabiofrau.RestAPi.services;

import com.fabiofrau.RestAPi.domain.entities.AuthorEntity;

import java.util.List;

public interface AuthorService {

    AuthorEntity save(AuthorEntity authorEntity);

    List<AuthorEntity> findAll();
}
