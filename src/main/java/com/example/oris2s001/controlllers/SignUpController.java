package com.example.oris2s001.controlllers;

import com.example.oris2s001.dto.UserForm;
import com.example.oris2s001.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signUpPage")
    public String getSignUpPage(){
        return "sign_up_page";
    }

    @PostMapping("/signUp")
    public String signUp(UserForm form){
        System.out.println(form.getEmail());
        signUpService.addUser(form);
        return "redirect:/signUpPage";
    }
}