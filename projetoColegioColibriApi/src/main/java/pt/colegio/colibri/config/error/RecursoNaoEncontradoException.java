package pt.colegio.colibri.config.error;

// Lançada quando um registo pedido pelo id (ou por uma relação) não existe.
// O RestExceptionHandler converte esta exceção em HTTP 404.
public class RecursoNaoEncontradoException extends RuntimeException {

    public RecursoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
