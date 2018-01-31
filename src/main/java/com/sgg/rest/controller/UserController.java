package com.sgg.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgg.rest.model.ApplicationUser;
import com.sgg.rest.repository.UserRepository;
import com.sgg.rest.service.UserService;

@RestController
@RequestMapping("/user") // This means URL's start with /user (after Application path)
//@SuppressWarnings("all")
public class UserController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	
	//curl 'localhost:8080/user/add?name=First&email=someemail@someemailprovider.com'	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public String addNewUser (@RequestParam String name
			, @RequestParam String email) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		ApplicationUser n = new ApplicationUser();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}
	// curl 'localhost:8080/user/all'
	@GetMapping(path="/all")
	public Iterable<ApplicationUser> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	
	// curl 'localhost:8080/user/delete?name=First'
	@GetMapping(path="/delete")
	public String deleteUserByName(@RequestParam String name) {
		userRepository.deleteByName(name);
		return "Deleted";
	}
	//curl 'localhost:8080/user/update?id=2'
	@GetMapping(path="/update")
	public String update(@RequestParam int id) {
		ApplicationUser sessionUser = userRepository.findOne(id);
		sessionUser.setName("syg");
		sessionUser.setEmail("sgg@syg.com");
		userRepository.save(sessionUser);
		return "Updated";
	}
	//curl 'localhost:8080/user/findById?id=2'
	@GetMapping(path="/findById")
	public ApplicationUser getUserById(@RequestParam int id) {
//	    User u = userRepository.findOne(id);
//	    if(u == null) {
//	        return null;
//	    }
	
	    return userService.findOne(id);
	}
	@RequestMapping(value="/sign-up", method=RequestMethod.POST)
	public String getNewUser( @RequestBody ApplicationUser u) {
		userRepository.save(u);
		return "user sign up success";
	}

}
