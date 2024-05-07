package pt.colegio.colibri.controller.dtos.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NotaResponseDTO {

    private Integer idNota;
    private Integer alunoId;
    private Integer disciplinaId;
    private Integer periodoId;
    private LocalDate dataAtribuicao;
    private Double nota;
}
