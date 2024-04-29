package pt.colegio.colibri.controller.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Login;
import pt.colegio.colibri.controller.dtos.LoginDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoginControllerMapper {

    LoginDTO convertToLoginDTO(Login login);
    Login convertToLogin(LoginDTO loginDTO);

    List<LoginDTO> convertToLoginDTOList(List<Login> logins);
    List<Login> convertToLoginList(List<LoginDTO> loginDTOS);
}
