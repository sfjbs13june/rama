package com.rama.db.controller;

import com.rama.db.model.Users;
import com.rama.db.repository.UserNotify;
import com.rama.db.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
public class UsersController {
    @Autowired
    public  UsersRepository usersRepository;
    @Autowired
    public  UserNotify userNotify;


    @GetMapping(value = "/read")
    public @ResponseBody
    Iterable<Users> getAll() {
        return usersRepository.findAll();
    }

    @PostMapping(value = "/create")
    public @ResponseBody
    String store(@RequestBody final Users users) {
        usersRepository.save(users);
        return userNotify.isSave();
    }

    @DeleteMapping(value = "/delete")
    public @ResponseBody
    String store(@RequestParam("id") final int id) {
        usersRepository.deleteById(id);
        return userNotify.isDeleted();
    }
}
