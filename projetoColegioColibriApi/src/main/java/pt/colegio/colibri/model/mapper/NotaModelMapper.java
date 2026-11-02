package pt.colegio.colibri.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pt.colegio.colibri.business.core.Nota;
import pt.colegio.colibri.model.entity.AlunoEntity;
import pt.colegio.colibri.model.entity.DisciplinaEntity;
import pt.colegio.colibri.model.entity.NotaEntity;
import pt.colegio.colibri.model.entity.PeriodoEntity;

import java.util.List;

//Este código é uma interface de mapeamento (mapper) escrita em Java para um projeto Maven com Spring Boot, utilizando
// a biblioteca MapStruct. MapStruct é uma biblioteca de código aberto que facilita a criação de mapeadores de objetos,
// permitindo converter objetos de um tipo para outro de maneira eficiente e segura.

//A anotação @Mapper(componentModel = "spring") indica que este mapeador será gerado como um bean Spring. Isso
// significa que o Spring Boot pode injetar automaticamente instâncias deste mapeador em outros beans, facilitando o
// uso do mapeador em todo o aplicativo.

//Em resumo, este código define um mapeador que facilita a conversão entre objetos Nota e NotaEntity, além de permitir
// a conversão de listas desses objetos. Isso é particularmente útil em aplicações Spring Boot para separar a lógica de
// negócios da persistência de dados, mantendo o código limpo e organizado.

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
