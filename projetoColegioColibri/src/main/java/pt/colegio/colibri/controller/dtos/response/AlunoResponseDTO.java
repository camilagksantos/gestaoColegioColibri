package pt.colegio.colibri.controller.dtos.response;

import lombok.Data;
import pt.colegio.colibri.business.core.Login;
import pt.colegio.colibri.business.core.Turma;

//No código fornecido, temos uma classe AlunoResponseDTO que é usada para representar os dados de resposta relacionados
// a um aluno em um projeto Java que utiliza Maven, Spring Boot e Lombok.

//Essa classe AlunoResponseDTO é um exemplo de um DTO (Data Transfer Object), que é usado para encapsular os dados que
// serão transferidos entre processos ou camadas de uma aplicação. No contexto de uma API RESTful construída com Spring
// Boot, por exemplo, essa classe poderia ser usada para enviar informações sobre um aluno de volta ao cliente após uma
// operação bem-sucedida, como criar ou atualizar um registro de aluno.

@Data
public class AlunoResponseDTO {

    private Integer id;
    private String nome;
    private String apelido;
    private Integer idade;
    private String email;
    private Login login;
    private Turma turma;
}
