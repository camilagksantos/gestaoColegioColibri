package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Periodo;
import pt.colegio.colibri.controller.dtos.request.PeriodoRequestDTO;
import pt.colegio.colibri.controller.dtos.response.PeriodoResponseDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PeriodoControllerMapper {

    PeriodoResponseDTO convertToPeriodoDTO(Periodo periodo);
    Periodo convertToPeriodo(PeriodoRequestDTO periodoRequestDTO);
    Periodo convertToPeriodo(PeriodoRequestDTO periodoRequestDTO, Integer idPeriodo);
    List<PeriodoResponseDTO> convertToPeriodoDTOList(List<Periodo> periodos);
}
