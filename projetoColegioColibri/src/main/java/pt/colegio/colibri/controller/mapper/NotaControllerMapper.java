package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pt.colegio.colibri.business.core.Nota;
import pt.colegio.colibri.controller.dtos.request.NotaRequestDTO;
import pt.colegio.colibri.controller.dtos.response.NotaResponseDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotaControllerMapper {
    NotaResponseDTO convertToNotaDTO(Nota nota);

    @Mapping(target = "disciplina.idDisciplina", source = "disciplinaId")
    @Mapping(target = "periodo.idPeriodo", source = "periodoId")
    Nota convertToNota(NotaRequestDTO notaRequestDTO);

    @Mapping(target = "disciplina.idDisciplina", source = "notaRequestDTO.disciplinaId")
    @Mapping(target = "periodo.idPeriodo", source = "notaRequestDTO.periodoId")
    Nota convertToNota(NotaRequestDTO notaRequestDTO, Integer idNota);

    List<NotaResponseDTO> convertToNotaDTOList(List<Nota> notas);
}
