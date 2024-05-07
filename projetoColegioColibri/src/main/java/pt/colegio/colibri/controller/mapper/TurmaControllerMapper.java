package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pt.colegio.colibri.business.core.Turma;
import pt.colegio.colibri.controller.dtos.request.TurmaRequestDTO;
import pt.colegio.colibri.controller.dtos.response.TurmaResponseDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TurmaControllerMapper {

    @Mapping(target = "professor.id", source = "professor.id")
    TurmaResponseDTO convertToTurmaDTO(Turma turma);
    @Mapping(target = "professor.id", source = "professorId")
    Turma convertToTurma(TurmaRequestDTO turmaRequestDTO);
    @Mapping(target = "professor.id", source = "turmaRequestDTO.professorId")
    Turma convertToTurma(TurmaRequestDTO turmaRequestDTO, Integer idTurma);
    List<TurmaResponseDTO> convertToTurmaDTOList(List<Turma> turmas);
}
