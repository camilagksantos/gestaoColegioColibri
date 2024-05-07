package pt.colegio.colibri.controller.dtos.response;

import lombok.Data;
import pt.colegio.colibri.business.core.enuns.Roles;

@Data
public class LoginResponseDTO {

    private Integer idLogin;
    private String username;
    private String password;
    private Roles role;
}
