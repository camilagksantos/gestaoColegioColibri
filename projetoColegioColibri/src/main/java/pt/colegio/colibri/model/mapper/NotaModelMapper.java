package pt.colegio.colibri.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pt.colegio.colibri.business.core.Aluno;
import pt.colegio.colibri.business.core.Disciplina;
import pt.colegio.colibri.business.core.Nota;
import pt.colegio.colibri.business.core.Periodo;
import pt.colegio.colibri.model.entity.AlunoEntity;
import pt.colegio.colibri.model.entity.DisciplinaEntity;
import pt.colegio.colibri.model.entity.NotaEntity;
import pt.colegio.colibri.model.entity.PeriodoEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotaModelMapper {

    @Mapping(target = "disciplina", source = "disciplina")
    @Mapping(target = "periodo", source = "periodo")
    @Mapping(target = "aluno", source = "aluno")
    NotaEntity convertToNotaEntity(Nota nota, DisciplinaEntity disciplina, PeriodoEntity periodo, AlunoEntity aluno);

    @Mapping(target = "alunoId", source = "aluno.idAluno")
    Nota convertToNota(NotaEntity notaEntity);
    List<Nota> convertToNotaList(List<NotaEntity> notaEntities);
}
