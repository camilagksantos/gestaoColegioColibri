package pt.colegio.colibri.controller.dtos;

import lombok.Data;
import pt.colegio.colibri.business.core.enuns.Roles;

@Data
public class LoginDTO {

    private Integer idLogin;
    private String username;
    private String password;
    private Roles role;
}
