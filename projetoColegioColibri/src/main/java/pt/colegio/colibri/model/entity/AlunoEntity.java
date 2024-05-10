package pt.colegio.colibri.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

// Anotação @Data do Lombok, que gera automaticamente getters, setters, toString, equals e hashCode
// Anotação @Entity indica que esta classe é uma entidade JPA e deve ser persistida na base de dados
// Anotação @Table especifica o nome da tabela na base de dados onde os dados desta entidade serão armazenados
// Implementação da interface Serializable para permitir a serialização da entidade
// Anotação @Id indica que este campo é a chave primária da entidade
// Estratégia de geração de valor para a chave primária, neste caso, autoincremento

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

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "login_id", referencedColumnName = "id_login")
    private LoginEntity login;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "turma_id", referencedColumnName = "id_turma")
    private TurmaEntity turma;
}
