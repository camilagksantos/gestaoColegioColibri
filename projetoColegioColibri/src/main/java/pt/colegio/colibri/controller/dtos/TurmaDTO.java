package pt.colegio.colibri.controller.dtos;

import lombok.Data;

@Data
public class TurmaDTO {

    private Integer idTurma;
    private String designacao;
    private Integer professorId;
}
