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
}
