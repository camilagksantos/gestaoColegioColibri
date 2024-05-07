package pt.colegio.colibri.controller.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TurmaRequestDTO {
    @NotBlank
    private String designacao;
    @NotNull
    private Integer professorId;
}
