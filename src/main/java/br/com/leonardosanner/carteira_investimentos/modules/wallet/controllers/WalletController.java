package br.com.leonardosanner.carteira_investimentos.modules.wallet.controllers;

import br.com.leonardosanner.carteira_investimentos.modules.user.UserRepositoryService;
import br.com.leonardosanner.carteira_investimentos.modules.wallet.WalletEntity;
import br.com.leonardosanner.carteira_investimentos.modules.wallet.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import br.com.leonardosanner.carteira_investimentos.modules.wallet.services.WalletRepositoryService;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserRepositoryService userRepositoryService;

    @Autowired
    private WalletRepositoryService walletRepositoryService;

    @PostMapping("/create")
    public void createWallet(@RequestBody WalletEntity walletEntity,
                             @RequestAttribute String username) {

        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        this.walletRepositoryService.createWallet(walletEntity, username);
    }
}
