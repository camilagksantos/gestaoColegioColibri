package pt.colegio.colibri.business.core;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Nota {
    private Integer idNota;
    private Integer alunoId;
    private Integer disciplinaId;
    private Integer semestreId;
    private LocalDate dataAtribuicao;
    private Double nota;
}
