package pt.colegio.colibri.controller.dtos.response;

import lombok.Data;

@Data
public class FuncionarioResponseDTO {

    private Integer id;
    private String nome;
    private String apelido;
    private Integer idade;
    private String email;
    private Integer loginId;
}
