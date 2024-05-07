package pt.colegio.colibri.model.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Periodo;
import pt.colegio.colibri.model.entity.PeriodoEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PeriodoModelMapper {

    PeriodoEntity convertToPeriodoEntity(Periodo periodo);
    Periodo convertToPeriodo(PeriodoEntity periodoEntity);
    List<Periodo> convertToPeriodoList(List<PeriodoEntity> periodoEntities);
}
