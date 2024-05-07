package pt.colegio.colibri.business.core;

import lombok.Data;

@Data
public class Pessoa {

    private Integer id;
    private String nome;
    private String apelido;
    private Integer idade;
    private String email;
    private Login login;
}
