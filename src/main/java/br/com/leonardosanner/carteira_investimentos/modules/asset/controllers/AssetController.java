package br.com.leonardosanner.carteira_investimentos.modules.asset.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leonardosanner.carteira_investimentos.modules.asset.AssetEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/asset")
public class AssetController {
    
    @PostMapping("/")
    public void addAsset(@Valid @RequestBody AssetEntity assetEntity) {
        // use case
    }
}
