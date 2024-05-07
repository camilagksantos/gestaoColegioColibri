package pt.colegio.colibri.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pt.colegio.colibri.business.core.Turma;
import pt.colegio.colibri.model.entity.FuncionarioEntity;
import pt.colegio.colibri.model.entity.TurmaEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TurmaModelMapper {

    @Mapping(target = "professor.idFuncionario", source = "professor.id")
    TurmaEntity convertToTurmaEntity(Turma turma);

    @Mapping(target = "professor", source = "professor")
    TurmaEntity convertToTurmaEntity(Turma turma, FuncionarioEntity professor);

    @Mapping(target = "professor.id", source = "professor.idFuncionario")
    Turma convertToTurma(TurmaEntity turmaEntity);
    List<Turma> convertToTurmaList(List<TurmaEntity> turmaEntities);

}
