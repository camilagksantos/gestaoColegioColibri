package pt.colegio.colibri.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pt.colegio.colibri.business.core.Aluno;
import pt.colegio.colibri.model.entity.AlunoEntity;
import pt.colegio.colibri.model.entity.LoginEntity;
import pt.colegio.colibri.model.entity.TurmaEntity;

import java.util.List;

//Este código é uma interface de mapeamento (mapper) usando a biblioteca MapStruct, especificamente projetada para
// um projeto Java Maven com Spring Boot. O objetivo principal dessa interface é converter objetos entre diferentes
// representações, neste caso, entre entidades de banco de dados (AlunoEntity) e modelos
// de negócio (Aluno).

//A anotação @Mapper(componentModel = "spring") indica que este mapeador será gerado como um bean Spring. Isso
// significa que o Spring Boot pode injetar automaticamente instâncias deste mapeador em outros beans, facilitando
// o uso dessas conversões de objeto.

//Em resumo, essa interface de mapeamento facilita a conversão entre entidades de banco de dados e modelos de
// negócio, simplificando a manipulação de dados e a integração entre as camadas de uma aplicação Spring Boot.

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
