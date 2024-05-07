package pt.colegio.colibri.model;

import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Disciplina;
import pt.colegio.colibri.model.entity.DisciplinaEntity;
import pt.colegio.colibri.model.mapper.DisciplinaModelMapper;
import pt.colegio.colibri.model.repository.DisciplinaRepository;

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

    public Disciplina getDisciplina(Integer idDisciplina) {
        DisciplinaEntity disciplinaEntity = disciplinaRepository.findById(idDisciplina)
                .orElseThrow(() -> new RuntimeException("Registo não Encontrado!"));
        return disciplinaModelMapper.convertToDisciplina(disciplinaEntity);
    }

    public Disciplina addDisciplina(Disciplina disciplina) {
        DisciplinaEntity disciplinaEntity = disciplinaModelMapper.convertToDisciplinaEntity(disciplina);

        disciplinaRepository.save(disciplinaEntity);

        return disciplinaModelMapper.convertToDisciplina(disciplinaEntity);
    }

    public Disciplina updateDisciplina(Disciplina disciplina) {
        DisciplinaEntity disciplinaEntity = disciplinaModelMapper.convertToDisciplinaEntity(disciplina);

        disciplinaRepository.save(disciplinaEntity);

        return disciplinaModelMapper.convertToDisciplina(disciplinaEntity);
    }

    public void deleteDisciplina(Integer idDisciplina) {
        disciplinaRepository.deleteById(idDisciplina);
    }
}
