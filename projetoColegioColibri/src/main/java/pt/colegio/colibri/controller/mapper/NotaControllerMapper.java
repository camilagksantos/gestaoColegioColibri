package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Nota;
import pt.colegio.colibri.controller.dtos.NotaDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotaControllerMapper {

    NotaDTO convertToNotaDTO(Nota nota);
    Nota convertToNota(NotaDTO notaDTO);

    List<NotaDTO> convertToNotaDTOList(List<Nota> notas);
    List<Nota> convertToNotaList(List<NotaDTO> notaDTOS);
}
