package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Login;
import pt.colegio.colibri.controller.dtos.request.LoginRequestDTO;
import pt.colegio.colibri.controller.dtos.response.LoginResponseDTO;

import java.util.List;

//Este código define uma interface de mapeamento (LoginControllerMapper) usando a biblioteca MapStruct, uma ferramenta
// popular para mapeamento de objetos em projetos Java. O mapeamento de objetos é uma prática comum em aplicações
// Spring Boot para converter entre diferentes tipos de objetos, como DTOs (Data Transfer Objects) e entidades de
// domínio, facilitando a comunicação entre camadas da aplicação e a serialização/deserialização de dados.

//A anotação @Mapper é usada para indicar que a interface é um mapeador MapStruct. O atributo componentModel = "spring"
// especifica que o mapeador deve ser gerado como um bean Spring, permitindo que ele seja injetado em outros beans da
// aplicação.

//Em resumo, essa interface de mapeamento facilita a conversão entre objetos de domínio e DTOs, simplificando a
// manipulação de dados entre diferentes partes do aplicativo, especialmente em contextos onde a separação de
// responsabilidades é crucial, como em arquiteturas baseadas em Spring Boot. O uso de anotações @Mapping permite
//// definir regras de mapeamento personalizadas, tornando o código mais limpo e fácil de entender.

@Mapper(componentModel = "spring")
public interface LoginControllerMapper {
    LoginResponseDTO convertToLoginDTO(Login login);

    Login convertToLogin(LoginRequestDTO loginRequestDTO);

    Login convertToLogin(LoginRequestDTO loginRequestDTO, Integer idLogin);

    List<LoginResponseDTO> convertToLoginDTOList(List<Login> logins);
}
