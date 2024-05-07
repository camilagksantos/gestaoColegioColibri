package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pt.colegio.colibri.business.core.Aluno;
import pt.colegio.colibri.controller.dtos.request.AlunoRequestDTO;
import pt.colegio.colibri.controller.dtos.response.AlunoResponseDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlunoControllerMapper {

    AlunoResponseDTO convertToAlunoDTO(Aluno aluno);
    Aluno convertToAluno(AlunoRequestDTO alunoRequestDTO);
    @Mapping(target = "id", source = "idAluno")
    Aluno convertToAluno(AlunoRequestDTO alunoRequestDTO, Integer idAluno);

    List<AlunoResponseDTO> convertToAlunoDTOList(List<Aluno> alunos);
}
