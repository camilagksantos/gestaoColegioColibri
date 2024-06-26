package pt.colegio.colibri.model.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Disciplina;
import pt.colegio.colibri.model.entity.DisciplinaEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DisciplinaModelMapper {

    DisciplinaEntity convertToDisciplinaEntity(Disciplina disciplina);
    Disciplina convertToDisciplina(DisciplinaEntity disciplinaEntity);
    List<Disciplina> convertToDisciplinaList(List<DisciplinaEntity> disciplinaEntities);
}
