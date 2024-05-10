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
@Table(name="turma")
public class TurmaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_turma")
    private Integer idTurma;

    @Column(name="designacao")
    private String designacao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "professor_id", referencedColumnName = "id_funcionario")
    private FuncionarioEntity professor;
}