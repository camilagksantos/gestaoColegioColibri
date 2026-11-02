package pt.colegio.colibri.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pt.colegio.colibri.business.core.Turma;
import pt.colegio.colibri.model.entity.FuncionarioEntity;
import pt.colegio.colibri.model.entity.TurmaEntity;

import java.util.List;

//A interface TurmaModelMapper é definida para converter objetos de um tipo Turma para um tipo TurmaEntity, e
// vice-versa. Isso é comum em aplicações Spring Boot, onde você pode querer separar a lógica de negócios (domínio)
// das representações de dados específicas da camada de persistência (como JPA entities).

//A anotação @Mapper é usada para indicar que esta interface é um mapeador MapStruct. O atributo componentModel =
// "spring" especifica que o mapeador deve ser gerado como um bean Spring, permitindo que ele seja injetado em outros
// beans da aplicação.

//Em resumo, este código define um mapeador MapStruct para converter entre objetos Turma e TurmaEntity, facilitando a
// manipulação de dados entre a camada de domínio e a camada de persistência em uma aplicação Spring Boot.

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
