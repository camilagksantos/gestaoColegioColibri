package pt.colegio.colibri.model;

import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Aluno;
import pt.colegio.colibri.model.mapper.AlunoModelMapper;
import pt.colegio.colibri.model.repository.AlunoRepository;

import java.util.List;

@Component
public class AlunoModel {

    private final AlunoRepository alunoRepository;
    private final AlunoModelMapper alunoModelMapper;

    public AlunoModel(AlunoRepository alunoRepository, AlunoModelMapper alunoModelMapper) {
        this.alunoRepository = alunoRepository;
        this.alunoModelMapper = alunoModelMapper;
    }

    public List<Aluno> getAlunos() {
        var alunosEntity = alunoRepository.findAll();

        return alunoModelMapper.convertToAlunoList(alunosEntity);
    }
}
