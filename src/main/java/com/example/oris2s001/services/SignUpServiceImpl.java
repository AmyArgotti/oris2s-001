package com.example.oris2s001.services;

import com.example.oris2s001.dto.UserForm;
import com.example.oris2s001.models.User;
import com.example.oris2s001.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public void addUser(UserForm form) {
        User user = User.builder()
                .email(form.getEmail())
                .password(form.getPassword())
                .build();
        System.out.println(form.getEmail());
        usersRepository.save(user);
    }
}