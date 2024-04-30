package pt.colegio.colibri.model.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Aluno;
import pt.colegio.colibri.model.entity.AlunoEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlunoModelMapper {

    AlunoEntity convertToAlunoEntity(Aluno aluno);
    Aluno convertToAluno(AlunoEntity alunoEntity);

    List<AlunoEntity> convertToAlunoEntityList(List<Aluno> alunos);
    List<Aluno> convertToAlunoList(List<AlunoEntity> alunoEntities);
}
