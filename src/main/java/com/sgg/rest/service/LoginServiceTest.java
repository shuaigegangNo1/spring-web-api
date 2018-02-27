package com.sgg.rest.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sgg.rest.model.ApplicationUser;
import com.sgg.rest.service.LoginService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTest {
    @Autowired
    private LoginService loginService;
    @Test
    public void Login() throws Exception {
        ApplicationUser u = loginService.Login("hxw1","5201" );
        Assert.assertEquals("hxw1",u.getName());
    }
}