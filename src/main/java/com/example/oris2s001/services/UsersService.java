package com.example.oris2s001.services;

import com.example.oris2s001.dto.UsersDto;

import java.util.List;



public interface UsersService {
    List<UsersDto> getAllUsers();
}