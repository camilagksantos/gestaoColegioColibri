package pt.colegio.colibri.model.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Periodo;
import pt.colegio.colibri.model.entity.PeriodoEntity;

import java.util.List;

//Este código é uma interface de mapeamento (mapper) escrita em Java para um projeto Maven com Spring Boot, utilizando
// a biblioteca MapStruct. MapStruct é uma biblioteca de código aberto que facilita a criação de mapeadores de objetos,
// permitindo converter entre diferentes tipos de objetos de maneira eficiente e segura.

//A anotação @Mapper é usada para indicar que a interface é um mapeador MapStruct. O atributo componentModel = "spring"
// especifica que o mapeador deve ser gerado como um bean Spring, permitindo que ele seja injetado em outros beans
// Spring.

//Em resumo, este código define uma interface de mapeamento que utiliza MapStruct para converter entre objetos Periodo
// e PeriodoEntity, além de suportar a conversão de listas desses objetos. Isso é útil para separar a lógica de
// negócios (domínio) da lógica de acesso aos dados (entidades), melhorando a manutenibilidade e a testabilidade do
// código.

@Mapper(componentModel = "spring")
public interface PeriodoModelMapper {

    PeriodoEntity convertToPeriodoEntity(Periodo periodo);

    Periodo convertToPeriodo(PeriodoEntity periodoEntity);

    List<Periodo> convertToPeriodoList(List<PeriodoEntity> periodoEntities);
}
