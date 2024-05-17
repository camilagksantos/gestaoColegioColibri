package pt.colegio.colibri.business.core;

import lombok.Data;
import pt.colegio.colibri.business.core.enuns.Roles;

//A seguinte classe modelo não apresenta construtores, getters, setters,
// tostring e hashcode por que são geradas automaticamentes pelo lombok e geradas pelo spring

@Data
public class Login {
    private Integer idLogin;
    private String username;
    private String password;
    //este atributo é uma enumeração
    private Roles role;
}
