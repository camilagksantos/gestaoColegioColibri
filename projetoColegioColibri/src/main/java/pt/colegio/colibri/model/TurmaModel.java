package pt.colegio.colibri.model;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Turma;
import pt.colegio.colibri.model.entity.FuncionarioEntity;
import pt.colegio.colibri.model.entity.TurmaEntity;
import pt.colegio.colibri.model.mapper.TurmaModelMapper;
import pt.colegio.colibri.model.repository.FuncionarioRepository;
import pt.colegio.colibri.model.repository.TurmaRepository;

import java.util.List;

@Component
public class TurmaModel {
    private final TurmaRepository turmaRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final TurmaModelMapper turmaModelMapper;

    public TurmaModel(TurmaRepository turmaRepository, FuncionarioRepository funcionarioRepository, TurmaModelMapper turmaModelMapper) {
        this.turmaRepository = turmaRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.turmaModelMapper = turmaModelMapper;
    }

    public List<Turma> getTurmas() {
        var turmasEntity = turmaRepository.findAll();

        return turmaModelMapper.convertToTurmaList(turmasEntity);
    }

    public Turma getTurma(Integer idTurma) {
        TurmaEntity turmaEntity = turmaRepository.findById(idTurma)
                                                 .orElseThrow(() -> new RuntimeException("Registo não Encontrado!"));

        return turmaModelMapper.convertToTurma(turmaEntity);
    }

    @Transactional
    public Turma addTurma(Turma turma) {
        var professor = getFuncionario( turma.getProfessor().getId() );

        TurmaEntity turmaEntity = turmaModelMapper.convertToTurmaEntity(turma, professor);

        turmaRepository.save(turmaEntity);

        return turmaModelMapper.convertToTurma(turmaEntity);
    }

    @Transactional
    public Turma updateTurma(Turma turma) {
        var professor = getFuncionario( turma.getProfessor().getId() );

        TurmaEntity turmaEntity = turmaModelMapper.convertToTurmaEntity(turma, professor);

        turmaRepository.save(turmaEntity);

        return turmaModelMapper.convertToTurma(turmaEntity);
    }

    public void deleteTurma(Integer idTurma) {
        turmaRepository.deleteById(idTurma);
    }

    private FuncionarioEntity getFuncionario(Integer professorId){
        return funcionarioRepository.findById( professorId )
                                    .orElseThrow(() -> new RuntimeException("Funcionario não Encontrado!"));
    }
}