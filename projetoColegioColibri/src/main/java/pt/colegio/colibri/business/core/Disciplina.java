package pt.colegio.colibri.business.core;

import lombok.Data;

//A seguinte classe modelo não apresenta construtores, getters, setters,
// tostring e hashcode por que são geradas automaticamentes pelo lombok e geradas pelo spring

@Data
public class Disciplina {
    private Integer idDisciplina;
    private String designacao;
}
