package br.com.leonardosanner.carteira_investimentos.modules.user.useCases;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leonardosanner.carteira_investimentos.modules.exceptions.search.UserFoundException;
import br.com.leonardosanner.carteira_investimentos.modules.user.UserEntity;
import br.com.leonardosanner.carteira_investimentos.modules.user.UserRepository;
import br.com.leonardosanner.carteira_investimentos.modules.user.dto.UserExistenceDTO;

@Service
public class UserExistenceUseCase {
 
    @Autowired
    UserRepository userRepository;

    public void execute(UserExistenceDTO userExistenceDTO) {
        Optional<UserEntity> result = this.userRepository.findByUsername(userExistenceDTO.getUsername());

        if (result.isPresent()) {
            throw new UserFoundException(); 
        }
        
    }
    
}
