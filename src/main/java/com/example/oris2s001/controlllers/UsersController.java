package com.example.oris2s001.controlllers;


import com.example.oris2s001.dto.UsersDto;
import com.example.oris2s001.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;
    @GetMapping("/users")
    public String getUsersPage(Model model) {
        List<UsersDto> usersList = usersService.getAllUsers();
        if (usersList != null) {
            model.addAttribute("usersList", usersList);
        } else {
            model.addAttribute("usersList", Collections.emptyList());
        }
        return "users_page";
    }
}