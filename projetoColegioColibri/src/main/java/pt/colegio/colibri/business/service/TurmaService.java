package pt.colegio.colibri.business.service;

import org.springframework.stereotype.Service;
import pt.colegio.colibri.business.core.Turma;
import pt.colegio.colibri.model.TurmaModel;

import java.util.List;

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
