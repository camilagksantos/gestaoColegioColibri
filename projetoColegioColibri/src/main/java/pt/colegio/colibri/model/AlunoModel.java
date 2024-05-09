package pt.colegio.colibri.model;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Aluno;
import pt.colegio.colibri.model.entity.AlunoEntity;
import pt.colegio.colibri.model.entity.LoginEntity;
import pt.colegio.colibri.model.entity.TurmaEntity;
import pt.colegio.colibri.model.mapper.AlunoModelMapper;
import pt.colegio.colibri.model.repository.AlunoRepository;
import pt.colegio.colibri.model.repository.LoginRepository;
import pt.colegio.colibri.model.repository.TurmaRepository;

import java.util.List;

@Component
public class AlunoModel {

    private final AlunoRepository alunoRepository;
    private final AlunoModelMapper alunoModelMapper;
    private final LoginRepository loginRepository;
    private final TurmaRepository turmaRepository;

    public AlunoModel(AlunoRepository alunoRepository, AlunoModelMapper alunoModelMapper, LoginRepository loginRepository, TurmaRepository turmaRepository) {
        this.alunoRepository = alunoRepository;
        this.alunoModelMapper = alunoModelMapper;
        this.loginRepository = loginRepository;
        this.turmaRepository = turmaRepository;
    }

    public List<Aluno> getAlunos() {
        var alunosEntity = alunoRepository.findAll();

        return alunoModelMapper.convertToAlunoList(alunosEntity);
    }

    public Aluno getAluno(Integer idAluno) {
        AlunoEntity alunoEntity = alunoRepository.findById(idAluno)
                                                 .orElseThrow(() -> new RuntimeException("Aluno não Encontrado!"));

        return alunoModelMapper.convertToAluno(alunoEntity);
    }

    @Transactional
    public Aluno addAluno(Aluno aluno) {
        var login = getLogin( aluno.getLogin().getIdLogin());
        var turma = getTurma( aluno.getTurma().getIdTurma());

        AlunoEntity alunoEntity = alunoModelMapper.convertToAlunoEntity(aluno, login, turma);

        alunoRepository.save(alunoEntity);

        return alunoModelMapper.convertToAluno(alunoEntity);
    }

    @Transactional
    public Aluno updateAluno(Aluno aluno) {
        var login = getLogin( aluno.getLogin().getIdLogin());
        var turma = getTurma( aluno.getTurma().getIdTurma());

        AlunoEntity alunoEntity = alunoModelMapper.convertToAlunoEntity(aluno, login, turma);

        alunoRepository.save(alunoEntity);

        return alunoModelMapper.convertToAluno(alunoEntity);
    }

    public void deleteAluno(Integer idAluno) {
        alunoRepository.deleteById(idAluno);
    }

    private LoginEntity getLogin(Integer loginId){
        return loginRepository.findById(loginId)
                              .orElseThrow(() -> new RuntimeException("Login não Encontrado!"));
    }

    private TurmaEntity getTurma(Integer turmaId){
        return turmaRepository.findById(turmaId)
                .orElseThrow(() -> new RuntimeException("Turma não Encontrada!"));
    }
}
