package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pt.colegio.colibri.business.core.Aluno;
import pt.colegio.colibri.controller.dtos.request.AlunoRequestDTO;
import pt.colegio.colibri.controller.dtos.response.AlunoResponseDTO;

import java.util.List;

//Este código é uma interface de mapeamento (mapper) usando a biblioteca MapStruct para um projeto Java com Spring Boot
// e Maven. O objetivo principal dessa interface é converter objetos entre diferentes representações, neste caso,
// entre objetos de domínio (Aluno) e DTOs (Data Transfer Objects) usados para comunicação entre camadas ou serviços
// (AlunoRequestDTO e AlunoResponseDTO).

//A anotação @Mapper(componentModel = "spring") indica que essa interface é um mapeador MapStruct que deve ser gerado
// como um bean Spring. Isso permite que o Spring gerencie a instância do mapeador como um bean, facilitando a injeção
// de dependências e o uso em outros componentes do Spring.

//Em resumo, essa interface de mapeamento facilita a conversão entre objetos de domínio e DTOs, simplificando a
// manipulação de dados entre diferentes partes do aplicativo, especialmente em contextos onde a separação de
// responsabilidades é crucial, como em arquiteturas baseadas em Spring Boot. O uso de anotações @Mapping permite
//// definir regras de mapeamento personalizadas, tornando o código mais limpo e fácil de entender.

@Mapper(componentModel = "spring")
public interface AlunoControllerMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "login.idLogin", source = "login.idLogin")
    @Mapping(target = "turma.idTurma", source = "turma.idTurma")
    AlunoResponseDTO convertToAlunoDTO(Aluno aluno);

    //@Mapping(target = "id", source = "idAluno")
    @Mapping(target = "login.idLogin", source = "loginId")
    @Mapping(target = "turma.idTurma", source = "turmaId")
    Aluno convertToAluno(AlunoRequestDTO alunoRequestDTO);

    @Mapping(target = "id", source = "idAluno")
    @Mapping(target = "login.idLogin", source = "alunoRequestDTO.loginId")
    @Mapping(target = "turma.idTurma", source = "alunoRequestDTO.turmaId")
    Aluno convertToAluno(AlunoRequestDTO alunoRequestDTO, Integer idAluno);

    List<AlunoResponseDTO> convertToAlunoDTOList(List<Aluno> alunos);
}
