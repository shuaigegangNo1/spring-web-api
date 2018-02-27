package com.sgg.rest.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.sgg.rest.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
    @Transactional
    Book findByName(String name);
    
}
