package pt.colegio.colibri.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import pt.colegio.colibri.business.core.Funcionario;

import java.util.List;

@Data
@Entity
@Table(name="turma")
public class TurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_turma")
    private Integer idTurma;

    @Column(name="designacao")
    private String designacao;


    //@Column(name="professor_id")
    //private FuncionarioEntity professor;


}
