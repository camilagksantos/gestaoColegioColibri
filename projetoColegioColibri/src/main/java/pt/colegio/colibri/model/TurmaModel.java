package pt.colegio.colibri.model;

import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Turma;
import pt.colegio.colibri.model.mapper.TurmaModelMapper;
import pt.colegio.colibri.model.repository.TurmaRepository;

import java.util.List;

@Component
public class TurmaModel {

    private final TurmaRepository turmaRepository;
    private final TurmaModelMapper turmaModelMapper;

    public TurmaModel(TurmaRepository turmaRepository, TurmaModelMapper turmaModelMapper) {
        this.turmaRepository = turmaRepository;
        this.turmaModelMapper = turmaModelMapper;
    }

    public List<Turma> getTurmas() {
        var turmasEntity = turmaRepository.findAll();

        return turmaModelMapper.convertToTurmaList(turmasEntity);
    }
}
