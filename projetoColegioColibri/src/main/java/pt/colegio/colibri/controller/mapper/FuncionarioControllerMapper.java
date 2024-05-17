package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pt.colegio.colibri.business.core.Funcionario;
import pt.colegio.colibri.controller.dtos.request.FuncionarioRequestDTO;
import pt.colegio.colibri.controller.dtos.response.FuncionarioResponseDTO;

import java.util.List;

//Este código é uma interface de mapeamento (Mapper) usando a biblioteca MapStruct, especificamente projetada para um
// projeto Java Maven com Spring Boot. A interface FuncionarioControllerMapper é responsável por converter objetos
// entre diferentes representações, facilitando a comunicação entre camadas do aplicativo.

//A anotação @Mapper(componentModel = "spring") indica que este mapeador será gerado como um bean Spring. Isso
// significa que o Spring Boot pode injetar automaticamente instâncias deste mapeador em outros beans, facilitando o
// uso de conversões de objeto.

//Em resumo, essa interface de mapeamento facilita a conversão entre objetos de domínio e DTOs, simplificando a
// manipulação de dados entre diferentes partes do aplicativo, especialmente em contextos onde a separação de
// responsabilidades é crucial, como em arquiteturas baseadas em Spring Boot. O uso de anotações @Mapping permite
//// definir regras de mapeamento personalizadas, tornando o código mais limpo e fácil de entender.

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
