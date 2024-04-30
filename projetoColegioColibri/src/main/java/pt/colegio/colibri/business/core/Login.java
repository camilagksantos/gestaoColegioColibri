package pt.colegio.colibri.business.core;

import lombok.Data;
import pt.colegio.colibri.business.core.enuns.Roles;

@Data
public class Login {

    private Integer idLogin;
    private String username;
    private String password;
    private Roles role;
}
