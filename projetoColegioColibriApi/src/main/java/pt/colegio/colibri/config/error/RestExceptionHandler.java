package pt.colegio.colibri.config.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

//Esta classe é parte de uma aplicação Spring Boot Maven, especificamente dentro do pacote pt.colegio.colibri.config.error.
// Ele define uma classe chamada RestExceptionHandler que é usada para lidar globalmente com exceções lançadas em
//  tod o aplicativo.

//Anotação @RestControllerAdvice: Esta anotação é colocada acima da declaração da classe RestExceptionHandler. Ela
// indica que essa classe é um "advice" RESTful, ou seja, um ponto de intercepção global para manipular exceções
// lançadas em qualquer controlador RESTful da aplicação. Isso permite centralizar a lógica de tratamento de erros,
// tornando o código mais limpo e fácil de manter.

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ProblemDetail exceptionNaoEncontrado(Exception exception){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setTitle(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        problemDetail.setDetail(exception.getMessage());
        problemDetail.setProperty("TimeStamp", LocalDateTime.now().toString());

        return problemDetail;
    }


}
