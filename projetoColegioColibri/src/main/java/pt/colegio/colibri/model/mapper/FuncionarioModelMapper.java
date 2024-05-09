package pt.colegio.colibri.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pt.colegio.colibri.business.core.Funcionario;
import pt.colegio.colibri.model.entity.FuncionarioEntity;
import pt.colegio.colibri.model.entity.LoginEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FuncionarioModelMapper {
    @Mapping(target = "idFuncionario", source = "funcionario.id")
    @Mapping(target = "login", source = "login")
    FuncionarioEntity convertToFuncionarioEntity(Funcionario funcionario, LoginEntity login);

    @Mapping(target = "id", source = "idFuncionario")
    Funcionario convertToFuncionario(FuncionarioEntity funcionarioEntity);

    List<Funcionario> convertToFuncionarioList(List<FuncionarioEntity> funcionarioEntities);

}
