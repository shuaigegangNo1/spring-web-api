package com.sgg.rest.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sgg.rest.model.ApplicationUser;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface UserRepository extends CrudRepository<ApplicationUser, Integer> {

    Long countByName(String name);

    @Transactional
    Long deleteByName(String name);

    @Transactional
    List<ApplicationUser> removeByName(String name);
    
    @Transactional
    ApplicationUser findByName(String name);
    //@Transactional
    // String update(Integer id);
    
//    @Modifying
//    @Query("UPDATE User c SET c.name = :name WHERE c.id = :id")
//    Integer setNameForId(@Param("name"); String name, @Param("id")
}
