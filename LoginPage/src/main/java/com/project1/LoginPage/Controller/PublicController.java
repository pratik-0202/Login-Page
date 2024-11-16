package com.project1.LoginPage.Controller;

import com.project1.LoginPage.entity.Users;
import com.project1.LoginPage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("ROLE_USER"));
        userService.saveEntry(user);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }
}
