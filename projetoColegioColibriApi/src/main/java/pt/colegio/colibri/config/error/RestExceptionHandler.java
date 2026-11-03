package pt.colegio.colibri.config.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

// Converte exceções em ProblemDetail com o status HTTP correto.
// Mensagens expostas ao cliente são sempre textos controlados pela aplicação. Exceções inesperadas
// devolvem uma mensagem genérica e são registadas no log, sem expor detalhes internos.
@RestControllerAdvice
public class RestExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ProblemDetail recursoNaoEncontrado(RecursoNaoEncontradoException exception) {
        return criar(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ProblemDetail registoNaoEncontrado(EmptyResultDataAccessException exception) {
        return criar(HttpStatus.NOT_FOUND, "Registo não encontrado.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail dadosInvalidos(MethodArgumentNotValidException exception) {
        ProblemDetail problemDetail = criar(HttpStatus.BAD_REQUEST, "Dados inválidos.");

        Map<String, String> erros = new LinkedHashMap<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(erro -> erros.putIfAbsent(erro.getField(), erro.getDefaultMessage()));
        problemDetail.setProperty("erros", erros);

        return problemDetail;
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ProblemDetail acessoNegado(AccessDeniedException exception) {
        return criar(HttpStatus.FORBIDDEN, "Acesso negado.");
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ProblemDetail utilizadorNaoEncontrado(UsernameNotFoundException exception) {
        return criar(HttpStatus.UNAUTHORIZED, "Utilizador autenticado não possui login válido.");
    }

    // Violação de integridade referencial (ex.: apagar um aluno que tem notas) ou de restrição única.
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ProblemDetail conflitoDeDados(DataIntegrityViolationException exception) {
        return criar(HttpStatus.CONFLICT,
                "Operação não permitida: o registo está associado a outros dados ou viola uma restrição.");
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail erroInterno(Exception exception) {
        log.error("Erro não tratado", exception);
        return criar(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno do servidor.");
    }

    private ProblemDetail criar(HttpStatus status, String detalhe) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setTitle(status.getReasonPhrase());
        problemDetail.setDetail(detalhe);
        problemDetail.setProperty("TimeStamp", LocalDateTime.now().toString());
        return problemDetail;
    }
}
