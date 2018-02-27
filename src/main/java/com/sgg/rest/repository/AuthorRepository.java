package com.sgg.rest.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.sgg.rest.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
    @Transactional
    Author findByName(String name);
}
