package pt.colegio.colibri.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="funcionario")
public class FuncionarioEntity implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_funcionario")
    private Integer idFuncionario;

    @Column(name="nome")
    private String nome;

    @Column(name="apelido")
    private String apelido;

    @Column(name="idade")
    private Integer idade;

    @Column(name="email")
    private String email;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "login_id", referencedColumnName = "id_login")
    private LoginEntity login;
}
