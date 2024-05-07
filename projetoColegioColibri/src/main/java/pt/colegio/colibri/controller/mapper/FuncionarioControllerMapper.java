package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pt.colegio.colibri.business.core.Funcionario;
import pt.colegio.colibri.controller.dtos.request.FuncionarioRequestDTO;
import pt.colegio.colibri.controller.dtos.response.FuncionarioResponseDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FuncionarioControllerMapper {

    @Mapping(target = "loginId", source = "login.idLogin")
    FuncionarioResponseDTO convertToFuncionarioDTO(Funcionario funcionario);
    Funcionario convertToFuncionario(FuncionarioRequestDTO funcionarioRequestDTO);
    @Mapping(target = "id", source = "idFuncionario")
    Funcionario convertToFuncionario(FuncionarioRequestDTO funcionarioRequestDTO, Integer idFuncionario);

    List<FuncionarioResponseDTO> convertToFuncionarioDTOList(List<Funcionario> funcionario);
}
