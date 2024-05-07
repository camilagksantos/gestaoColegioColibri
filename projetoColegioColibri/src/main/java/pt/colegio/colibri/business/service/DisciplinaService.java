package pt.colegio.colibri.business.service;

import org.springframework.stereotype.Service;
import pt.colegio.colibri.business.core.Disciplina;
import pt.colegio.colibri.model.DisciplinaModel;

import java.util.List;

@Service
public class DisciplinaService {

    private final DisciplinaModel disciplinaModel;

    public DisciplinaService(DisciplinaModel disciplinaModel) {
        this.disciplinaModel = disciplinaModel;
    }

    public List<Disciplina> getDisciplinas(){
        return disciplinaModel.getDisciplinas();
    }

    public Disciplina getDisciplina(Integer idDisciplina) {
        return disciplinaModel.getDisciplina(idDisciplina);
    }

    public Disciplina addDisciplina(Disciplina disciplina) {
        return disciplinaModel.addDisciplina(disciplina);
    }

    public Disciplina updateDisciplina(Disciplina disciplina) {
        return disciplinaModel.updateDisciplina(disciplina);
    }

    public void deleteDisciplina(Integer idDisciplina) {
        disciplinaModel.deleteDisciplina(idDisciplina);
    }
}
