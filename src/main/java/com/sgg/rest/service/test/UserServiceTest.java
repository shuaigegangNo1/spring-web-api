package com.sgg.rest.service.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sgg.rest.model.User;
import com.sgg.rest.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void findOne() throws Exception {
        User u = userService.findOne(2);
        Assert.assertEquals("someemail2@someemailprovider.com", u.getEmail());
    }
}