package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Turma;
import pt.colegio.colibri.controller.dtos.TurmaDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TurmaControllerMapper {

    TurmaDTO convertToTurmaDTO(Turma turma);
    Turma convertToTurma(TurmaDTO turmaDTO);

    List<TurmaDTO> convertToTurmaDTOList(List<Turma> turmas);
    List<Turma> convertToTurmaList(List<TurmaDTO> turmaDTOS);
}
