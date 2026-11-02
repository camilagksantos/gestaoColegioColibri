package pt.colegio.colibri.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pt.colegio.colibri.business.core.Funcionario;
import pt.colegio.colibri.model.entity.FuncionarioEntity;
import pt.colegio.colibri.model.entity.LoginEntity;

import java.util.List;

//Este código é uma interface de mapeamento (mapper) usando a biblioteca MapStruct, especificamente projetada para um
// projeto Java Maven com Spring Boot. O objetivo principal dessa interface é converter objetos entre diferentes
// representações, neste caso, entre Funcionario e FuncionarioEntity, além de lidar com a conversão de uma lista de
// FuncionarioEntity para uma lista de Funcionario

//A anotação @Mapper(componentModel = "spring") indica que este mapeador será gerado como um bean Spring. Isso
// significa que o Spring Boot pode injetar automaticamente instâncias deste mapeador em outros beans quando necessário.

//Em resumo, essa interface de mapeamento facilita a conversão entre diferentes representações de dados, especialmente
// útil em camadas separadas de uma aplicação, como a camada de domínio e a camada de persistência, permitindo uma
// separação clara de responsabilidades e facilitando a manutenção do código.

@Mapper(componentModel = "spring")
public interface FuncionarioModelMapper {
    @Mapping(target = "idFuncionario", source = "funcionario.id")
    @Mapping(target = "login", source = "login")
    FuncionarioEntity convertToFuncionarioEntity(Funcionario funcionario, LoginEntity login);

    @Mapping(target = "id", source = "idFuncionario")
    Funcionario convertToFuncionario(FuncionarioEntity funcionarioEntity);

    List<Funcionario> convertToFuncionarioList(List<FuncionarioEntity> funcionarioEntities);

}
