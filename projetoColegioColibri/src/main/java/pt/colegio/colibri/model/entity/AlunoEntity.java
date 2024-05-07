package pt.colegio.colibri.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="aluno")
public class AlunoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_aluno")
    private Integer idAluno;

    @Column(name="nome")
    private String nome;

    @Column(name="apelido")
    private String apelido;

    @Column(name="idade")
    private Integer idade;

    @Column(name="email")
    private String email;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "login_id", referencedColumnName = "id_login")
    private LoginEntity loginEntity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "turma_id", referencedColumnName = "id_turma")
    private TurmaEntity turmaEntity;
}
