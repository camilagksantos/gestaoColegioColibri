package pt.colegio.colibri.controller.dtos.response;

import lombok.Data;

@Data
public class AlunoResponseDTO {

    private Integer id;
    private String nome;
    private String apelido;
    private Integer idade;
    private String email;
    private Integer loginId;
    private Integer turmaId;
}
