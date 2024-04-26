package pt.colegio.colibri.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
public class PessoaEntity {

    @Column(name="nome")
    private String nome;

    @Column(name="apelido")
    private String apelido;

    @Column(name="idade")
    private Integer idade;

    @Column(name="email")
    private String email;

    @Column(name="login_id")
    private LoginEntity loginId;
}
