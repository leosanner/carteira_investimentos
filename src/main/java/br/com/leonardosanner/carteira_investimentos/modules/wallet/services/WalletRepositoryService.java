package br.com.leonardosanner.carteira_investimentos.modules.wallet.services;

import br.com.leonardosanner.carteira_investimentos.modules.exceptions.search.WalletNotFoundException;
import br.com.leonardosanner.carteira_investimentos.modules.user.UserEntity;
import br.com.leonardosanner.carteira_investimentos.modules.user.UserRepositoryService;
import br.com.leonardosanner.carteira_investimentos.modules.wallet.WalletEntity;
import br.com.leonardosanner.carteira_investimentos.modules.wallet.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class WalletRepositoryService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserRepositoryService userRepositoryService;

    public Optional<WalletEntity> getWallet(String name) {
        return this.walletRepository.findByName(name);
    }

    public void createWallet(WalletEntity walletEntity, String userUsername) {
        var result = getWallet(walletEntity.getName());
//        System.out.println(result);

        if (result.isEmpty()) {
            Optional <UserEntity> user = this.userRepositoryService.getUser(userUsername);

            this.userRepositoryService.getUser(userUsername).ifPresent(userEntity -> {
                walletEntity.setUserEntity(userEntity);
                System.out.println("Wallet created.");
                this.walletRepository.save(walletEntity);
            });
            return;
        }

        throw new RuntimeException("Wallet already exists.");
    }
}
