package br.com.leonardosanner.carteira_investimentos.modules.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leonardosanner.carteira_investimentos.modules.user.UserEntity;
import br.com.leonardosanner.carteira_investimentos.modules.user.UserRepository;
import br.com.leonardosanner.carteira_investimentos.modules.user.dto.AuthUserDTO;
import br.com.leonardosanner.carteira_investimentos.modules.user.dto.UserExistenceDTO;
import br.com.leonardosanner.carteira_investimentos.modules.user.useCases.UserExistenceUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserExistenceUseCase userExistenceUseCase;
    
    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserEntity userEntity) {
        userExistenceUseCase.execute(new UserExistenceDTO(userEntity.getUsername()));
        userRepository.save(userEntity);

        return ResponseEntity.ok().body(userEntity);
    }

    @GetMapping("/search")
    public ResponseEntity<UserEntity> searchUser(@RequestBody AuthUserDTO authUserDTO) {
        // fazer verificação se o usuário existe e senha é compatível;
        return null;
    }
}
