package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Periodo;
import pt.colegio.colibri.controller.dtos.PeriodoDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PeriodoControllerMapper {

    PeriodoDTO convertToPeriodoDTO(Periodo periodo);
    Periodo convertToPeriodo(PeriodoDTO periodoDTO);

    List<PeriodoDTO> convertToPeriodoDTOList(List<Periodo> periodos);
    List<Periodo> convetToPeriodo(List<PeriodoDTO> periodoDTOS);
}
