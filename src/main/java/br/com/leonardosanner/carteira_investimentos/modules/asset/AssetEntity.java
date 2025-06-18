package br.com.leonardosanner.carteira_investimentos.modules.asset;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import br.com.leonardosanner.carteira_investimentos.modules.walletRegister.WalletRegisterEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Entity(name = "asset")
public class AssetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank()
    private String name;
    
    @NotBlank()
    private String currency;
    
    @NotBlank()
    private double value;

    @OneToMany(mappedBy = "assetEntity")
    private List<WalletRegisterEntity> walletRegisterEntities = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime updateTime;
}
