package pt.colegio.colibri.controller.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import pt.colegio.colibri.business.core.enuns.Roles;

//Este código define uma classe LoginRequestDTO em Java, que é utilizada para representar os dados de requisição
// relacionados a um login em um projeto Maven com Spring Boot.

//As importações no início do arquivo incluem classes do Jakarta Validation API (jakarta.validation.constraints.NotBlank
// e jakarta.validation.constraints.NotNull) e a anotação @Data do Lombok. Jakarta Validation é uma API para validação
// de dados, enquanto Lombok é uma biblioteca que ajuda a reduzir a quantidade de código boilerplate.

//Essa classe é um exemplo de como os DTOs podem ser usados para validar e estruturar os dados recebidos em uma
// aplicação Spring Boot. Ao usar as anotações de validação do Jakarta Validation, você garante que os dados recebidos
// atendam aos critérios definidos antes de serem processados pela aplicação.

@Data
public class LoginRequestDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotNull
    private Roles role;
}
