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
    @Mapping(target = "login.idLogin", source = "loginId")
    Funcionario convertToFuncionario(FuncionarioRequestDTO funcionarioRequestDTO);

    @Mapping(target = "id", source = "idFuncionario")
    @Mapping(target = "login.idLogin", source = "funcionarioRequestDTO.loginId")
    Funcionario convertToFuncionario(FuncionarioRequestDTO funcionarioRequestDTO, Integer idFuncionario);

    List<FuncionarioResponseDTO> convertToFuncionarioDTOList(List<Funcionario> funcionario);
}
