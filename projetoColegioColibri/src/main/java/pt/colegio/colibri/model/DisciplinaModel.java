package pt.colegio.colibri.model;

import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Disciplina;
import pt.colegio.colibri.model.mapper.DisciplinaModelMapper;
import pt.colegio.colibri.model.mapper.LoginModelMapper;
import pt.colegio.colibri.model.repository.DisciplinaRepository;
import pt.colegio.colibri.model.repository.LoginRepository;

import java.util.List;

@Component
public class DisciplinaModel {

    private final DisciplinaRepository disciplinaRepository;
    private final DisciplinaModelMapper disciplinaModelMapper;

    public DisciplinaModel(DisciplinaRepository disciplinaRepository, DisciplinaModelMapper disciplinaModelMapper) {
        this.disciplinaRepository = disciplinaRepository;
        this.disciplinaModelMapper = disciplinaModelMapper;
    }

    public List<Disciplina> getDisciplinas(){
        var disciplinaEntity = disciplinaRepository.findAll();

        return disciplinaModelMapper.convertToDisciplinaList(disciplinaEntity);
    }
}
