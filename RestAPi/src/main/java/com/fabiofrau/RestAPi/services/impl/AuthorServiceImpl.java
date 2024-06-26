package com.fabiofrau.RestAPi.services.impl;

import com.fabiofrau.RestAPi.domain.entities.AuthorEntity;
import com.fabiofrau.RestAPi.repositories.AuthorRepository;
import com.fabiofrau.RestAPi.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity save(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }

    @Override
    public List<AuthorEntity> findAll() {
        return StreamSupport.stream(authorRepository
                        .findAll()
                        .spliterator(),false)
                .collect(Collectors.toList());
    }
}
