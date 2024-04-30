package pt.colegio.colibri.model.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Turma;
import pt.colegio.colibri.model.entity.TurmaEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TurmaModelMapper {

    TurmaEntity convertToTurmaEntity(Turma turma);
    Turma convertToTurma(TurmaEntity turmaEntity);

    List<TurmaEntity> convertToTurmaEntityList(List<Turma> turmas);
    List<Turma> convertToTurmaList(List<TurmaEntity> turmaEntities);
}
