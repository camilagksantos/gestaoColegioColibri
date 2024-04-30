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
}
