package com.example.msjoin.repository;

import com.example.msjoin.entity.User;

import java.util.List;

public interface UserRepository {

    public List<User> getAllUser();

    public User getUserByUserId(int userId);
}
