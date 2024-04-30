package pt.colegio.colibri.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="periodo")
public class PeriodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_periodo")
    private Integer idPeriodo;

    @Column(name="designacao")
    private String designacao;
}
