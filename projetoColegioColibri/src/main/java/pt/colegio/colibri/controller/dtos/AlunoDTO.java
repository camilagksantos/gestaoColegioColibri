package pt.colegio.colibri.controller.dtos;

import lombok.Data;

@Data
public class AlunoDTO {

    private Integer id;
    private String nome;
    private String apelido;
    private Integer idade;
    private String email;
    private Integer loginId;
    private Integer turmaId;
}
