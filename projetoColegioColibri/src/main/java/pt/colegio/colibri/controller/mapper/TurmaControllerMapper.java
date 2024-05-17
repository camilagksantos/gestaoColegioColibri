package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pt.colegio.colibri.business.core.Turma;
import pt.colegio.colibri.controller.dtos.request.TurmaRequestDTO;
import pt.colegio.colibri.controller.dtos.response.TurmaResponseDTO;

import java.util.List;

//Este código é uma interface de mapeamento (mapper) usando a biblioteca MapStruct, especificamente projetada para um
// projeto Java Maven com Spring Boot. O propósito principal dessa interface é converter objetos entre diferentes tipos,
// neste caso, entre objetos de domínio (Turma) e seus equivalentes DTOs (Data Transfer Objects) para requisições
// (TurmaRequestDTO) e respostas (TurmaResponseDTO).

//A anotação @Mapper(componentModel = "spring") indica que este mapeador será gerado como um bean Spring. Isso significa
// que o Spring Boot pode injetar automaticamente instâncias deste mapeador em outros beans, facilitando o uso dos
// métodos de mapeamento.

//Em resumo, essa interface de mapeamento facilita a conversão entre objetos de domínio e DTOs, simplificando a
// manipulação de dados entre diferentes partes do aplicativo, especialmente em contextos onde a separação de
// responsabilidades é crucial, como em arquiteturas baseadas em Spring Boot. O uso de anotações @Mapping permite
//// definir regras de mapeamento personalizadas, tornando o código mais limpo e fácil de entender.

@Mapper(componentModel = "spring")
public interface TurmaControllerMapper {
    @Mapping(target = "professor.id", source = "professor.id")
    TurmaResponseDTO convertToTurmaDTO(Turma turma);

    @Mapping(target = "professor.id", source = "professorId")
    Turma convertToTurma(TurmaRequestDTO turmaRequestDTO);

    @Mapping(target = "professor.id", source = "turmaRequestDTO.professorId")
    Turma convertToTurma(TurmaRequestDTO turmaRequestDTO, Integer idTurma);

    List<TurmaResponseDTO> convertToTurmaDTOList(List<Turma> turmas);
}
