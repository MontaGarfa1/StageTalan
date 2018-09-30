package com.stageMonta.TalanTunisie.controllers;

import com.stageMonta.TalanTunisie.model.AppUser;
import com.stageMonta.TalanTunisie.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
@RestController
@RequestMapping
public class AccountController {
    @Autowired
    AccountService accountService;
    @ResponseBody
    @PostMapping(value = "register")
    public AppUser  saveUser(@RequestBody AppUser user){
        AppUser user1 = this.accountService.saveUser(user);
        this.accountService.addRoleToUser(user.getUsername(),"ADMIN");
        return user1;

    }
}
