package pt.colegio.colibri.controller.dtos.response;

import lombok.Data;

@Data
public class TurmaResponseDTO {

    private Integer idTurma;
    private String designacao;
    private FuncionarioResponseDTO professor;
}
