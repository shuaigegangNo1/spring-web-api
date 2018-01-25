package com.sgg.rest.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.sgg.rest.model.Account;
import com.sgg.rest.model.User;

public interface AccountRepository extends CrudRepository<Account, Integer> {
	 @Transactional
	    List<Account> findAccountsByUser(User u);
}
