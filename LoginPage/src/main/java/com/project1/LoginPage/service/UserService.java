package com.project1.LoginPage.service;

import com.project1.LoginPage.entity.Users;
import com.project1.LoginPage.repo.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void saveEntry(Users userName){
        userRepo.save(userName);
    }

    public List<Users> getAll(){
        return userRepo.findAll();
    }

    public Optional<Users> findById(ObjectId id){
        return userRepo.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepo.deleteById(id);
    }

    public Users findByUserName(String userName){
        return userRepo.findByUserName(userName);
    }
}
