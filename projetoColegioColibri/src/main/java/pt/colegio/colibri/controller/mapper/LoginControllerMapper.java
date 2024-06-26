package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pt.colegio.colibri.business.core.Login;
import pt.colegio.colibri.controller.dtos.request.AuthLoginRequestDTO;
import pt.colegio.colibri.controller.dtos.request.LoginRequestDTO;
import pt.colegio.colibri.controller.dtos.response.LoginResponseDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoginControllerMapper {
    LoginResponseDTO convertToLoginDTO(Login login);

    Login convertToLogin(LoginRequestDTO loginRequestDTO);

    Login convertToLogin(LoginRequestDTO loginRequestDTO, Integer idLogin);

    List<LoginResponseDTO> convertToLoginDTOList(List<Login> logins);

    @Mapping(target = "idLogin", ignore = true)
    @Mapping(target = "role", ignore = true)
    Login authConvertToLogin(AuthLoginRequestDTO authLoginRequestDTO);
}
