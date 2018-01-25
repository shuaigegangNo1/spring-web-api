package com.sgg.rest.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sgg.rest.model.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface UserRepository extends CrudRepository<User, Integer> {

    Long countByName(String name);

    @Transactional
    Long deleteByName(String name);

    @Transactional
    List<User> removeByName(String name);
    
    //@Transactional
    // String update(Integer id);
    
//    @Modifying
//    @Query("UPDATE User c SET c.name = :name WHERE c.id = :id")
//    Integer setNameForId(@Param("name"); String name, @Param("id")
}
