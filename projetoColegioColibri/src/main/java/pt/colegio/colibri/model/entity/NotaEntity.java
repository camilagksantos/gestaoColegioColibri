package pt.colegio.colibri.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="nota")
public class NotaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_nota")
    private Integer idNota;

//    @Column(name="aluno_id")
//    private AlunoEntity aluno;
//
//    @ManyToOne
//    @Column(name="disciplina_id")
//    private DisciplinaEntity disciplina;
//
//    @Column(name="periodo_id")
//    private PeriodoEntity periodo;
//
//    @Column(name="data_atribuicao")
//    private LocalDate dataAtribuicao;
//
//    @Column(name="nota")
//    private Double nota;
}
