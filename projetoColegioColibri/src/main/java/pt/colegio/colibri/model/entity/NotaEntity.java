package pt.colegio.colibri.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name="nota")
public class NotaEntity implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_nota")
    private Integer idNota;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "aluno_id", referencedColumnName = "id_aluno")
    private AlunoEntity aluno;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "disciplina_id", referencedColumnName = "id_disciplina")
    private DisciplinaEntity disciplina;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "periodo_id", referencedColumnName = "id_periodo")
    private PeriodoEntity periodo;

    @Column(name="data_atribuicao")
    private LocalDate dataAtribuicao;

    @Column(name="nota")
    private Double nota;
}
