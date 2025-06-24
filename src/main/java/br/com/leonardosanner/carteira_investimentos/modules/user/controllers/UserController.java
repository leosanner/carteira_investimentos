package br.com.leonardosanner.carteira_investimentos.modules.user.controllers;

import br.com.leonardosanner.carteira_investimentos.modules.user.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.leonardosanner.carteira_investimentos.modules.user.UserEntity;
import br.com.leonardosanner.carteira_investimentos.modules.user.UserRepository;
import br.com.leonardosanner.carteira_investimentos.modules.user.dto.AuthUserDTO;
import br.com.leonardosanner.carteira_investimentos.modules.user.dto.ResponseTokenDTO;
import br.com.leonardosanner.carteira_investimentos.modules.user.dto.UserExistenceDTO;
import br.com.leonardosanner.carteira_investimentos.modules.user.useCases.AuthUserCredentialsUseCase;
import br.com.leonardosanner.carteira_investimentos.modules.user.useCases.EncondeUserPasswordUseCase;
import br.com.leonardosanner.carteira_investimentos.modules.user.useCases.UserExistenceUseCase;
import jakarta.validation.Valid;
import java.util.List;

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

    @Autowired
    private UserRepositoryService userRepositoryService; // test ; apenas para produção

    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserEntity userEntity) {
        userExistenceUseCase.execute(new UserExistenceDTO(userEntity.getUsername()));
        userEntity.setPassword(encondeUserPasswordUseCase.excecute(userEntity.getPassword()));

        userRepository.save(userEntity);

        return ResponseEntity.ok().body(userEntity);
    }

    @PostMapping("/token")
    public ResponseEntity<ResponseTokenDTO> searchUser(@RequestBody AuthUserDTO authUserDTO) {
      
        return authUserCredentialsUseCase.execute(authUserDTO);
    }

    @GetMapping("/all-users")
    public ResponseEntity<List<UserEntity>> findAllUsers() {

        return new ResponseEntity<>(userRepositoryService.getAllUsers(), HttpStatusCode.valueOf(202));
    }
}
