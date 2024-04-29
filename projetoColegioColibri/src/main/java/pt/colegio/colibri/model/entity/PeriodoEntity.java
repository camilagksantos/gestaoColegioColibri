package pt.colegio.colibri.model.entity;

import jakarta.persistence.Column;

//@Data
//@Entity
//@Table(name="semestre")
public class PeriodoEntity {

    @Column(name="id_semestre")
    private Integer idSemestre;

    @Column(name="designacao")
    private String designacao;
}
