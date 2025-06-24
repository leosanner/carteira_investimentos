package br.com.leonardosanner.carteira_investimentos.modules.user;

import br.com.leonardosanner.carteira_investimentos.modules.exceptions.search.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRepositoryService { // This service will replace major part of the useCases I guess.

    @Autowired
    private UserRepository userRepository;

    public Optional<UserEntity> getUser(String username) {
        return userRepository.findByUsername(username);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
