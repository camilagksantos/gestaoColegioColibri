package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pt.colegio.colibri.business.core.Nota;
import pt.colegio.colibri.controller.dtos.request.NotaRequestDTO;
import pt.colegio.colibri.controller.dtos.response.NotaResponseDTO;

import java.util.List;

//Este código é uma interface de mapeamento (mapper) usando a biblioteca MapStruct, especificamente projetada para um
// projeto Java Maven com Spring Boot. O propósito principal dessa interface é converter objetos entre diferentes
// representações, neste caso, entre objetos de domínio (Nota) e seus equivalentes DTOs (Data Transfer Objects) para
// requisições (NotaRequestDTO) e respostas (NotaResponseDTO).

//A anotação @Mapper(componentModel = "spring") indica que este mapeador deve ser gerado como um bean Spring. Isso
// significa que o Spring pode injetar automaticamente instâncias deste mapeador em outros beans, facilitando o uso do
// mapeamento em todo o aplicativo.

//Em resumo, essa interface de mapeamento facilita a conversão entre objetos de domínio e DTOs, simplificando a
// manipulação de dados entre diferentes partes do aplicativo, especialmente em contextos onde a separação de
// responsabilidades é crucial, como em arquiteturas baseadas em Spring Boot. O uso de anotações @Mapping permite
//// definir regras de mapeamento personalizadas, tornando o código mais limpo e fácil de entender.

@Mapper(componentModel = "spring")
public interface NotaControllerMapper {
    NotaResponseDTO convertToNotaDTO(Nota nota);

    @Mapping(target = "disciplina.idDisciplina", source = "disciplinaId")
    @Mapping(target = "periodo.idPeriodo", source = "periodoId")
    Nota convertToNota(NotaRequestDTO notaRequestDTO);

    @Mapping(target = "disciplina.idDisciplina", source = "notaRequestDTO.disciplinaId")
    @Mapping(target = "periodo.idPeriodo", source = "notaRequestDTO.periodoId")
    Nota convertToNota(NotaRequestDTO notaRequestDTO, Integer idNota);

    List<NotaResponseDTO> convertToNotaDTOList(List<Nota> notas);
}