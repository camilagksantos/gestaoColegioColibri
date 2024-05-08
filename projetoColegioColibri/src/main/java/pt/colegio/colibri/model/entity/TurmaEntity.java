package pt.colegio.colibri.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import pt.colegio.colibri.business.core.Funcionario;

import java.io.Serializable;
import java.util.List;

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