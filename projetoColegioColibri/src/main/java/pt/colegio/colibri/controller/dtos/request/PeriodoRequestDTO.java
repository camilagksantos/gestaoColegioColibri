package pt.colegio.colibri.controller.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PeriodoRequestDTO {
    @NotBlank
    private String designacao;
}
