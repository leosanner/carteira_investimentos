package br.com.leonardosanner.carteira_investimentos.modules.user;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends JpaRepository<UserEntity, UUID>{
    Optional<UserEntity> findByUsername(String username); 
}
