package pt.colegio.colibri.model;

import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Aluno;
import pt.colegio.colibri.model.entity.AlunoEntity;
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

    public Aluno getAluno(Integer idAluno) {
        AlunoEntity alunoEntity = alunoRepository.findById(idAluno)
                .orElseThrow(() -> new RuntimeException("Registo não Encontrado!"));
        return alunoModelMapper.convertToAluno(alunoEntity);
    }

    public Aluno addAluno(Aluno aluno) {
        AlunoEntity alunoEntity = alunoModelMapper.convertToAlunoEntity(aluno);

        alunoRepository.save(alunoEntity);

        return alunoModelMapper.convertToAluno(alunoEntity);
    }

    public Aluno updateAluno(Aluno aluno) {
        AlunoEntity alunoEntity = alunoModelMapper.convertToAlunoEntity(aluno);

        alunoRepository.save(alunoEntity);

        return alunoModelMapper.convertToAluno(alunoEntity);
    }

    public void deleteAluno(Integer idAluno) {
        alunoRepository.deleteById(idAluno);
    }
}
