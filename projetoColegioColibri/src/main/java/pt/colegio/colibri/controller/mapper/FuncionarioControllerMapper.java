package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Funcionario;
import pt.colegio.colibri.controller.dtos.FuncionarioDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FuncionarioControllerMapper {

    FuncionarioDTO convertToFuncionarioDTO(Funcionario funcionario);
    Funcionario convertToFuncionario(FuncionarioDTO funcionarioDTO);

    List<FuncionarioDTO> convertToFuncionarioDTOList(List<Funcionario> funcionario);
    List<Funcionario> convertToFuncionarioList(List<FuncionarioDTO> funcionarioDTOS);
}
