package br.com.leonardosanner.carteira_investimentos.modules.user.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leonardosanner.carteira_investimentos.modules.user.UserEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/test")
    public String home() {
        return "Test";
    }
    
    @PostMapping("/")
    public void createUser(@Valid @RequestBody UserEntity userEntity) {
        //use case
    }
}
