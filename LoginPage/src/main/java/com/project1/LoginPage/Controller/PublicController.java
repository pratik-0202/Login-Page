package com.project1.LoginPage.Controller;

import com.project1.LoginPage.entity.Users;
import com.project1.LoginPage.service.MyUserDetailService;
import com.project1.LoginPage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class    PublicController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailService userDetailService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("ROLE_USER"));
        userService.saveEntry(user);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return userService.verify(user);
    }
}
