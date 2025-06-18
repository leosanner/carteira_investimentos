package br.com.leonardosanner.carteira_investimentos.modules.walletRegister;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import br.com.leonardosanner.carteira_investimentos.modules.asset.AssetEntity;
import br.com.leonardosanner.carteira_investimentos.modules.wallet.WalletEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "wallet_register")
public class WalletRegisterEntity {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private double quantity;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private WalletEntity walletEntity;

    @ManyToOne
    @JoinColumn(name = "asset_id")
    private AssetEntity assetEntity;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
