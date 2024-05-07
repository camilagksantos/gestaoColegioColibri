package pt.colegio.colibri.config.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

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
