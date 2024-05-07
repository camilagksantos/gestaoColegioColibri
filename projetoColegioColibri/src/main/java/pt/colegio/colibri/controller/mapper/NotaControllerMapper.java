package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Nota;
import pt.colegio.colibri.controller.dtos.request.NotaRequestDTO;
import pt.colegio.colibri.controller.dtos.response.NotaResponseDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotaControllerMapper {

    NotaResponseDTO convertToNotaDTO(Nota nota);
    Nota convertToNota(NotaRequestDTO notaRequestDTO);
    Nota convertToNota(NotaRequestDTO notaRequestDTO, Integer idNota);
    List<NotaResponseDTO> convertToNotaDTOList(List<Nota> notas);
}
