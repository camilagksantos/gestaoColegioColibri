package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pt.colegio.colibri.business.core.Aluno;
import pt.colegio.colibri.controller.dtos.request.AlunoRequestDTO;
import pt.colegio.colibri.controller.dtos.response.AlunoResponseDTO;

import java.util.List;

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
