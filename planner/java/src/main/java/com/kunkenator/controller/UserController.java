package com.kunkenator.controller;


import com.kunkenator.dao.UserDao;
import com.kunkenator.model.User;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin
@RestController
public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(value = "/users/current", method = RequestMethod.GET)
    public User getCurrentUser(Principal principal) {
        return userDao.findByUsername(principal.getName());
    }
}
