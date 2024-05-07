package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Disciplina;
import pt.colegio.colibri.controller.dtos.request.DisciplinaRequestDTO;
import pt.colegio.colibri.controller.dtos.response.DisciplinaResponseDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DisciplinaControllerMapper {

    DisciplinaResponseDTO convertToDisciplinaDTO(Disciplina disciplina);
    Disciplina convertToDisciplina(DisciplinaRequestDTO disciplinaRequestDTO);
    Disciplina convertToDisciplina(DisciplinaRequestDTO disciplinaRequestDTO, Integer idDisciplina);
    List<DisciplinaResponseDTO> convertToDisciplinaDTOList(List<Disciplina> disciplinas);
}
