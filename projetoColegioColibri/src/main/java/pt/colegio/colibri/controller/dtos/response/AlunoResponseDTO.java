package pt.colegio.colibri.controller.dtos.response;

import lombok.Data;
import pt.colegio.colibri.business.core.Login;
import pt.colegio.colibri.business.core.Turma;

@Data
public class AlunoResponseDTO {

    private Integer id;
    private String nome;
    private String apelido;
    private Integer idade;
    private String email;
    private Login login;
    private Turma turma;
}
