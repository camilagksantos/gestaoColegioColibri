package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Periodo;
import pt.colegio.colibri.controller.dtos.request.PeriodoRequestDTO;
import pt.colegio.colibri.controller.dtos.response.PeriodoResponseDTO;

import java.util.List;

//No código fornecido, temos uma interface de mapeador (PeriodoControllerMapper) que utiliza a biblioteca MapStruct
// para converter objetos entre diferentes tipos. MapStruct é uma biblioteca Java que facilita a conversão de objetos
// de um tipo para outro, especialmente útil em aplicações Spring Boot para mapear DTOs (Data Transfer Objects) para
// entidades e vice-versa.

//A anotação @Mapper(componentModel = "spring") indica que este mapeador deve ser gerado como um bean Spring. Isso
// significa que o MapStruct irá gerar uma implementação desta interface durante a fase de compilação, e essa
// implementação será gerenciada pelo Spring como um bean, permitindo que seja injetada em outros beans Spring.

//Em resumo, essa interface de mapeamento facilita a conversão entre objetos de domínio e DTOs, simplificando a
// manipulação de dados entre diferentes partes do aplicativo, especialmente em contextos onde a separação de
// responsabilidades é crucial, como em arquiteturas baseadas em Spring Boot. O uso de anotações @Mapping permite
//// definir regras de mapeamento personalizadas, tornando o código mais limpo e fácil de entender.

@Mapper(componentModel = "spring")
public interface PeriodoControllerMapper {
    PeriodoResponseDTO convertToPeriodoDTO(Periodo periodo);

    Periodo convertToPeriodo(PeriodoRequestDTO periodoRequestDTO);

    Periodo convertToPeriodo(PeriodoRequestDTO periodoRequestDTO, Integer idPeriodo);

    List<PeriodoResponseDTO> convertToPeriodoDTOList(List<Periodo> periodos);
}
