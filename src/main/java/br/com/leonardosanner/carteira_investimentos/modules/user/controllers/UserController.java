package br.com.leonardosanner.carteira_investimentos.modules.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leonardosanner.carteira_investimentos.modules.user.UserEntity;
import br.com.leonardosanner.carteira_investimentos.modules.user.UserRepository;
import br.com.leonardosanner.carteira_investimentos.modules.user.dto.AuthUserDTO;
import br.com.leonardosanner.carteira_investimentos.modules.user.dto.ResponseTokenDTO;
import br.com.leonardosanner.carteira_investimentos.modules.user.dto.UserExistenceDTO;
import br.com.leonardosanner.carteira_investimentos.modules.user.useCases.AuthUserCredentialsUseCase;
import br.com.leonardosanner.carteira_investimentos.modules.user.useCases.EncondeUserPasswordUseCase;
import br.com.leonardosanner.carteira_investimentos.modules.user.useCases.UserExistenceUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserExistenceUseCase userExistenceUseCase;

    @Autowired
    private AuthUserCredentialsUseCase authUserCredentialsUseCase;
    
    @Autowired
    private EncondeUserPasswordUseCase encondeUserPasswordUseCase;

    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserEntity userEntity) {
        userExistenceUseCase.execute(new UserExistenceDTO(userEntity.getUsername()));
        userEntity.setPassword(encondeUserPasswordUseCase.excecute(userEntity.getPassword()));

        userRepository.save(userEntity);

        return ResponseEntity.ok().body(userEntity);
    }

    @PostMapping("/get-token")
    public ResponseEntity<ResponseTokenDTO> searchUser(@RequestBody AuthUserDTO authUserDTO) {
      
        return authUserCredentialsUseCase.execute(authUserDTO);
       
    }
}
