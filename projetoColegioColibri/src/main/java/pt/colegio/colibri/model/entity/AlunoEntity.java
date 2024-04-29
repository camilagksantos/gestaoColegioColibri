package pt.colegio.colibri.model.entity;

import jakarta.persistence.*;
import lombok.Data;

//@Data
//@Entity
//@Table(name="aluno")
public class AlunoEntity extends PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_aluno")
    private Integer idAluno;

    @ManyToOne
    @Column(name="turma_id")
    private TurmaEntity turma;
}
