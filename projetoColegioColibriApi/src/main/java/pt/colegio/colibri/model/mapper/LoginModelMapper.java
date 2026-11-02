package pt.colegio.colibri.model.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Login;
import pt.colegio.colibri.model.entity.LoginEntity;

import java.util.List;

//Este código define uma interface de mapeamento (LoginModelMapper) que utiliza a biblioteca MapStruct para converter
// objetos entre diferentes tipos de entidades e modelos em um projeto Java que utiliza Spring Boot e Maven.

//A anotação @Mapper(componentModel = "spring") indica que este mapeador deve ser gerado como um bean Spring. Isso
// significa que o MapStruct irá gerar uma implementação desta interface durante o processo de compilação, e essa
// implementação será gerenciada pelo Spring como um bean, permitindo que seja injetada em outros beans ou serviços.

//Em resumo, este código define uma interface de mapeamento que facilita a conversão entre objetos de domínio e
// entidades, utilizando a biblioteca MapStruct para gerar automaticamente as implementações desses métodos de
// mapeamento. Isso simplifica o código e melhora a manutenibilidade, pois centraliza a lógica de mapeamento em um
// único lugar.

@Mapper(componentModel = "spring")
public interface LoginModelMapper {

    LoginEntity convertToLoginEntity(Login login);

    Login convertToLogin(LoginEntity loginEntity);

    List<Login> convertToLoginList(List<LoginEntity> loginEntities);
}
