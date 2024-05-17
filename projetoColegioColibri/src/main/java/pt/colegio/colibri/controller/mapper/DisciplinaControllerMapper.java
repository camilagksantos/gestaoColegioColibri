package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Disciplina;
import pt.colegio.colibri.controller.dtos.request.DisciplinaRequestDTO;
import pt.colegio.colibri.controller.dtos.response.DisciplinaResponseDTO;

import java.util.List;

//Este código define uma interface de mapeamento (DisciplinaControllerMapper) usando a biblioteca MapStruct, uma
// ferramenta popular para mapeamento de objetos em projetos Java. O mapeamento de objetos é uma prática comum em
// aplicações Spring Boot para converter entre diferentes tipos de objetos, como DTOs (Data Transfer Objects) e
// entidades de domínio, facilitando a comunicação entre camadas e a separação de responsabilidades.

//A anotação @Mapper(componentModel = "spring") indica que este mapeador deve ser gerado como um bean Spring.
// Isso significa que o MapStruct irá gerar uma implementação desta interface durante a fase de compilação, e essa
// implementação será gerenciada pelo Spring como um bean, permitindo que seja injetada em outros beans Spring.

//Em resumo, essa interface de mapeamento facilita a conversão entre objetos de domínio e DTOs, simplificando a
// manipulação de dados entre diferentes partes do aplicativo, especialmente em contextos onde a separação de
// responsabilidades é crucial, como em arquiteturas baseadas em Spring Boot. O uso de anotações @Mapping permite
//// definir regras de mapeamento personalizadas, tornando o código mais limpo e fácil de entender.

@Mapper(componentModel = "spring")
public interface DisciplinaControllerMapper {
    DisciplinaResponseDTO convertToDisciplinaDTO(Disciplina disciplina);

    Disciplina convertToDisciplina(DisciplinaRequestDTO disciplinaRequestDTO);

    Disciplina convertToDisciplina(DisciplinaRequestDTO disciplinaRequestDTO, Integer idDisciplina);

    List<DisciplinaResponseDTO> convertToDisciplinaDTOList(List<Disciplina> disciplinas);
}
