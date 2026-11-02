package pt.colegio.colibri.business.core;

import lombok.Data;

//A seguinte classe modelo não apresenta construtores, getters, setters,
// tostring e hashcode por que são geradas automaticamentes pelo lombok e geradas pelo spring

@Data
public class Pessoa {
    private Integer id;
    private String nome;
    private String apelido;
    private Integer idade;
    private String email;
    private Login login;
}
