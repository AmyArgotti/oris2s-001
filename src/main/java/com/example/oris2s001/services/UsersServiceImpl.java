package com.example.oris2s001.services;


import com.example.oris2s001.dto.UsersDto;
import com.example.oris2s001.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.oris2s001.dto.UsersDto.usersList;

@Component
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public List<UsersDto>getAllUsers(){
        return usersList(usersRepository.findAll());
    }
}