package com.demo.hellospring.service;
import java.util.List;
import java.util.Optional;

import com.demo.hellospring.dto.UserDto;
import com.demo.hellospring.model.User;

public interface UserService {
public boolean saveorupdate(UserDto userdto);
public boolean deleteUserByID(int id);
public List<User>getAllUser();
public Optional<User>getByID(int id);
public String signUp(UserDto userdto);
public String signIn(String name,String password);

public String sendEmail(String to,String textBody,String topic);
public int softDeleteById(int id);
}