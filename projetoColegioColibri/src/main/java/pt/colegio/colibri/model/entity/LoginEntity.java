package pt.colegio.colibri.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import pt.colegio.colibri.business.core.enuns.Roles;

@Data
@Entity
@Table(name="login")
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_login")
    private Integer idLogin;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="role" )
    @Enumerated(value = EnumType.STRING)
    private Roles role;
}
