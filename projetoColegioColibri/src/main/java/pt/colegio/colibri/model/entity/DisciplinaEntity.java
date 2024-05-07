package pt.colegio.colibri.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="disciplina")
public class DisciplinaEntity implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_disciplina")
    private Integer idDisciplina;

    @Column(name="designacao")
    private String designacao;
}
