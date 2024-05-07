package pt.colegio.colibri.controller.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class NotaRequestDTO {
    @NotNull
    private Integer alunoId;
    @NotNull
    private Integer disciplinaId;
    @NotNull
    private Integer periodoId;
    @NotNull
    private LocalDate dataAtribuicao;
    @NotNull
    private Double nota;
}
