package pt.colegio.colibri.business.core;

import lombok.Data;

@Data
public class Turma {

    private Integer idTurma;
    private String designacao;
    private Funcionario professor;
}
