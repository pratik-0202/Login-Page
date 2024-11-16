package com.project1.LoginPage.Controller;

import com.project1.LoginPage.entity.Users;
import com.project1.LoginPage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @PostMapping
    public ResponseEntity<?> addAdmin(@RequestBody Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("ROLE_ADMIN", "ROLE_USER"));
        userService.saveEntry(user);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Users> list = userService.getAll();
        if(list != null && !list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
