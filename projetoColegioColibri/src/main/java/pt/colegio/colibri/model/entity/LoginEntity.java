package pt.colegio.colibri.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import pt.colegio.colibri.business.core.enuns.Roles;

@Data
@Entity
@Table(name="login")
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_login")
    private Integer idLogin;

    @Column(name="user")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private Roles role;
}
