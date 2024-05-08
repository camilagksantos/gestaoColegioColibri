package pt.colegio.colibri.controller.dtos.response;

import lombok.Data;
import pt.colegio.colibri.business.core.Disciplina;
import pt.colegio.colibri.business.core.Periodo;

import java.time.LocalDate;

@Data
public class NotaResponseDTO {

    private Integer idNota;
    private Integer alunoId;
    private Disciplina disciplina;
    private Periodo periodo;
    private LocalDate dataAtribuicao;
    private Double nota;
}
