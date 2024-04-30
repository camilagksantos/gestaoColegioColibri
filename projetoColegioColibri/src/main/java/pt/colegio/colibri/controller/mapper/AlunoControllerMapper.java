package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Aluno;
import pt.colegio.colibri.controller.dtos.AlunoDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlunoControllerMapper {

    AlunoDTO convertToAlunoDTO(Aluno aluno);
    Aluno convertToAluno(AlunoDTO alunoDTO);

    List<AlunoDTO> convertToAlunoDTOList(List<Aluno> alunos);
    List<Aluno> convertToAlunoList(List<AlunoDTO> alunoDTOS);
}
