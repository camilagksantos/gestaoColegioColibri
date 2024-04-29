package pt.colegio.colibri.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="disciplina")
public class DisciplinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_disciplina")
    private Integer idDisciplina;

    @Column(name="designacao")
    private String designacao;
}
