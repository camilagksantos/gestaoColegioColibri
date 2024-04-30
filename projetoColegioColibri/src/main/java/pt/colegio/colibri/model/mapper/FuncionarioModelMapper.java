package pt.colegio.colibri.model.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Funcionario;
import pt.colegio.colibri.model.entity.FuncionarioEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FuncionarioModelMapper {

    FuncionarioEntity convertToFuncionarioEntity(Funcionario funcionario);
    Funcionario convertToFuncionario(FuncionarioEntity funcionarioEntity);

    List<FuncionarioEntity> convertToFuncionarioEntityList(List<Funcionario> funcionarios);
    List<Funcionario> convertToFuncionarioList(List<FuncionarioEntity> funcionarioEntities);
}
