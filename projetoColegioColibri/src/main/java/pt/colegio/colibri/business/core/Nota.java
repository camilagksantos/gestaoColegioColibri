package pt.colegio.colibri.business.core;

import lombok.Data;

import java.time.LocalDate;

//A seguinte classe modelo não apresenta construtores, getters, setters,
// tostring e hashcode por que são geradas automaticamentes pelo lombok e geradas pelo spring

@Data
public class Nota {
    private Integer idNota;
    private Integer alunoId;
    private Disciplina disciplina;
    private Periodo periodo;
    private LocalDate dataAtribuicao;
    private Double nota;
}
