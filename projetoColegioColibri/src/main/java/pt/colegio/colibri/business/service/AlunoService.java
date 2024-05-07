package pt.colegio.colibri.business.service;

import org.springframework.stereotype.Service;
import pt.colegio.colibri.business.core.Aluno;
import pt.colegio.colibri.model.AlunoModel;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoModel alunoModel;

    public AlunoService(AlunoModel alunoModel) {
        this.alunoModel = alunoModel;
    }

    public List<Aluno> getAlunos(){
        return alunoModel.getAlunos();
    }

    public Aluno getAluno(Integer idAluno) {
        return alunoModel.getAluno(idAluno);
    }

    public Aluno addAluno(Aluno aluno) {
        return alunoModel.addAluno(aluno);
    }

    public Aluno updateAluno(Aluno aluno) {
        return alunoModel.updateAluno(aluno);
    }

    public void deleteAluno(Integer idAluno) {
        alunoModel.deleteAluno(idAluno);
    }
}
