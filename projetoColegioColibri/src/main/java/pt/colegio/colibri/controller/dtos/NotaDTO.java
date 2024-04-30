package pt.colegio.colibri.controller.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NotaDTO {

    private Integer idNota;
    private Integer alunoId;
    private Integer disciplinaId;
    private Integer periodoId;
    private LocalDate dataAtribuicao;
    private Double nota;
}
