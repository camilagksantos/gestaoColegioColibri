package pt.colegio.colibri.controller.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FuncionarioRequestDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String apelido;
    @NotNull
    private Integer idade;
    @NotBlank
    private String email;
    @NotNull
    private Integer loginId;
}
