package pt.colegio.colibri.business.service;

import org.springframework.stereotype.Service;
import pt.colegio.colibri.business.core.Turma;
import pt.colegio.colibri.model.TurmaModel;

import java.util.List;

//Este código é parte de uma aplicação Spring Boot, especificamente uma classe de serviço (TurmaService) que interage
// com um modelo de dados (Turma) para realizar operações CRUD (Create, Read, Update, Delete) relacionadas a
// turmas de uma escola.

//A classe é anotada com @Service, marcando-a como um componente de serviço no Spring. Isso significa que o Spring
// pode gerenciar instâncias desta classe automaticamente.

@Service
public class TurmaService {
    private final TurmaModel turmaModel;

    public TurmaService(TurmaModel turmaModel) {
        this.turmaModel = turmaModel;
    }

    public List<Turma> getTurmas(){
        return turmaModel.getTurmas();
    }

    public Turma getTurma(Integer idTurma) {
        return turmaModel.getTurma(idTurma);
    }

    public Turma addTurma(Turma turma) {
        return turmaModel.addTurma(turma);
    }

    public Turma updateTurma(Turma turma) {
        return turmaModel.updateTurma(turma);
    }

    public void deleteTurma(Integer idTurma) {
        turmaModel.deleteTurma(idTurma);
    }
}
