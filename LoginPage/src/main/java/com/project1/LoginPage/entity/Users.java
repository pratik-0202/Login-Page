package com.project1.LoginPage.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Users")
@Data
public class Users {
    @Id
    private ObjectId id;
    private String userName;
    private String password;
    private List<String> roles;
}
