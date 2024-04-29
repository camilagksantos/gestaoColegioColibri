package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Disciplina;
import pt.colegio.colibri.controller.dtos.DisciplinaDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DisciplinaControllerMapper {

    DisciplinaDTO convertToDisciplinaDTO(Disciplina disciplina);
    Disciplina convertToDisciplina(DisciplinaDTO disciplinaDTO);

    List<DisciplinaDTO> convertToDisciplinaDTO(List<Disciplina> disciplinas);
    List<Disciplina> convertToDisciplina(List<DisciplinaDTO> disciplinaDTOS);
}
