package br.com.leonardosanner.carteira_investimentos.modules.wallet;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import br.com.leonardosanner.carteira_investimentos.modules.user.UserEntity;
import br.com.leonardosanner.carteira_investimentos.modules.walletRegister.WalletRegisterEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "wallet")
public class WalletEntity {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "walletEntity")
    private List<WalletRegisterEntity> walletRegisterEntities = new ArrayList<>();

    @CreationTimestamp
    LocalDateTime createdAt;
}
