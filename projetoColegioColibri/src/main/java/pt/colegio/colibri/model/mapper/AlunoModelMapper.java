package pt.colegio.colibri.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pt.colegio.colibri.business.core.Aluno;
import pt.colegio.colibri.model.entity.AlunoEntity;
import pt.colegio.colibri.model.entity.LoginEntity;
import pt.colegio.colibri.model.entity.TurmaEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlunoModelMapper {
    @Mapping(target = "idAluno", source = "aluno.id")
    @Mapping(target = "login", source = "login")
    @Mapping(target = "turma", source = "turma")
    AlunoEntity convertToAlunoEntity(Aluno aluno, LoginEntity login, TurmaEntity turma);

    @Mapping(target = "id", source = "idAluno")
    @Mapping(target = "login", source = "login")
    @Mapping(target = "turma", source = "turma")
    Aluno convertToAluno(AlunoEntity alunoEntity);

    List<Aluno> convertToAlunoList(List<AlunoEntity> alunoEntities);
}
