package pt.colegio.colibri.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="semestre")
public class SemestreEntity {

    @Column(name="id_semestre")
    private Integer idSemestre;

    @Column(name="designacao")
    private String designacao;
}
