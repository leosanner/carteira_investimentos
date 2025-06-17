package br.com.leonardosanner.carteira_investimentos.modules.user;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name="user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "[name] required field")
    private String name;

    @NotBlank(message = "[username] required field")
    @Pattern(regexp = " /^\\S*$/")
    private String username;
    
    @NotBlank(message = "[password] required field")
    @Length(min = 10, max = 25)
    @Pattern(regexp = " /^\\S*$/")
    private String password;
    
    @Email
    private String email;
    
    @Min(value = 18, message = "Your age must be grater or equal to (18).")
    private int age;
}
