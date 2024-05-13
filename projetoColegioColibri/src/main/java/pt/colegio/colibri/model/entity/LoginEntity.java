package pt.colegio.colibri.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pt.colegio.colibri.business.core.enuns.Roles;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

// Anotação @Data do Lombok, que gera automaticamente getters, setters, toString, equals e hashCode
// Anotação @Entity indica que esta classe é uma entidade JPA e deve ser persistida na base de dados
// Anotação @Table especifica o nome da tabela na base de dados onde os dados desta entidade serão armazenados
// Implementação da interface Serializable para permitir a serialização da entidade
// Anotação @Id indica que este campo é a chave primária da entidade
// Estratégia de geração de valor para a chave primária, neste caso, autoincremento

@Data
@Entity
@Table(name="login")
public class LoginEntity implements Serializable , UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_login")
    private Integer idLogin;

    @Column(name="username")
    @NotBlank
    private String username;

    @Column(name="password")
    @NotBlank
    private String password;

    @Column(name="role" )
    @Enumerated(value = EnumType.STRING)
    @NotNull
    private Roles role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
