package pt.colegio.colibri.controller.dtos.response;

import lombok.Data;

//No código fornecido, temos uma classe DisciplinaResponseDTO que é usada para representar os dados de resposta relacionados
// a uma disciplina em um projeto Java que utiliza Maven, Spring Boot e Lombok.

//Essa classe DisciplinaResponseDTO é um exemplo de um DTO (Data Transfer Object), que é usado para encapsular os dados que
// serão transferidos entre processos ou camadas de uma aplicação. No contexto de uma API RESTful construída com Spring
// Boot, por exemplo, essa classe poderia ser usada para enviar informações sobre um aluno de volta ao cliente após uma
// operação bem-sucedida, como criar ou atualizar um registro de aluno.

@Data
public class DisciplinaResponseDTO {

    private Integer idDisciplina;
    private String designacao;
}
