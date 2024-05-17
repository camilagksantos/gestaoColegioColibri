package pt.colegio.colibri.model.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Disciplina;
import pt.colegio.colibri.model.entity.DisciplinaEntity;

import java.util.List;

//Este código é uma interface de mapeamento (mapper) para a classe Disciplina em um projeto Java que utiliza Spring
// Boot e Maven. O propósito principal deste código é facilitar a conversão entre objetos de domínio (Disciplina) e
// seus equivalentes de entidade (DisciplinaEntity), além de permitir a conversão de listas desses objetos.

//A anotação @Mapper(componentModel = "spring") indica que este mapeador deve ser gerado como um bean do Spring. Isso
// significa que o Spring pode injetar automaticamente instâncias deste mapeador em outros beans, facilitando a
// conversão entre objetos de domínio e entidade em todo o aplicativo.

//Em resumo, este código define uma interface de mapeamento que utiliza a biblioteca MapStruct para simplificar a
// conversão entre objetos de domínio e entidade em um projeto Spring Boot. Isso ajuda a manter a separação de
// responsabilidades entre a camada de domínio e a camada de persistência, facilitando a manutenção e a escalabilidade
// do código.

@Mapper(componentModel = "spring")
public interface DisciplinaModelMapper {

    DisciplinaEntity convertToDisciplinaEntity(Disciplina disciplina);
    Disciplina convertToDisciplina(DisciplinaEntity disciplinaEntity);
    List<Disciplina> convertToDisciplinaList(List<DisciplinaEntity> disciplinaEntities);
}
