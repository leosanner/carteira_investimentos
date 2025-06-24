package br.com.leonardosanner.carteira_investimentos.modules.user;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import br.com.leonardosanner.carteira_investimentos.modules.wallet.WalletEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name="users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // verificar isso depois
    private UUID id;

    @NotBlank(message = "The field [name] is a required field.")
    private String name;

    @NotBlank(message = "The field [username] is a required field.")
    @Pattern(regexp = "\\S+", message = "The field [username] do not acept spaces between characters.")
    private String username;
    
    @NotBlank(message = "The field [password] is a required field.")
    @Length(min = 10, max = 100, message = "The current field [password] must be between (10) and (100).")
    @Pattern(regexp = "\\S+", message = "The field [username] do not acept spaces between characters.")
    private String password;
    
    @Email(message = "Invalid email format.")
    private String email;
    
    @Min(value = 18, message = "Your age must be grater or equal to (18).")
    private int age;

    @JsonManagedReference
    @OneToMany(mappedBy = "userEntity")
    List<WalletEntity> wallets = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;
}
