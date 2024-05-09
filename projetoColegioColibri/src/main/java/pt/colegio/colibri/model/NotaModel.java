package pt.colegio.colibri.model;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Nota;
import pt.colegio.colibri.model.entity.*;
import pt.colegio.colibri.model.mapper.NotaModelMapper;
import pt.colegio.colibri.model.repository.AlunoRepository;
import pt.colegio.colibri.model.repository.DisciplinaRepository;
import pt.colegio.colibri.model.repository.NotaRepository;
import pt.colegio.colibri.model.repository.PeriodoRepository;

import java.util.List;

@Component
public class NotaModel {

    private final NotaRepository notaRepository;
    private final NotaModelMapper notaModelMapper;
    private final DisciplinaRepository disciplinaRepository;
    private final PeriodoRepository periodoRepository;
    private final AlunoRepository alunoRepository;

    public NotaModel(NotaRepository notaRepository, NotaModelMapper notaModelMapper, DisciplinaRepository disciplinaRepository, PeriodoRepository periodoRepository, AlunoRepository alunoRepository) {
        this.notaRepository = notaRepository;
        this.notaModelMapper = notaModelMapper;
        this.disciplinaRepository = disciplinaRepository;
        this.periodoRepository = periodoRepository;
        this.alunoRepository = alunoRepository;
    }

    public List<Nota> getNotas() {
        var notasEntity = notaRepository.findAll();

        return notaModelMapper.convertToNotaList(notasEntity);
    }

    public Nota getNota(Integer idNota) {
        NotaEntity notaEntity = notaRepository.findById(idNota)
                                              .orElseThrow(() -> new RuntimeException("Registo não Encontrado!"));

        return notaModelMapper.convertToNota(notaEntity);
    }

    @Transactional
    public Nota addNota(Nota nota) {
        var disciplina = getDisciplina( nota.getDisciplina().getIdDisciplina());
        var periodo = getPeriodo(nota.getPeriodo().getIdPeriodo());
        var aluno = getAluno(nota.getAlunoId());

        NotaEntity notaEntity = notaModelMapper.convertToNotaEntity(nota, disciplina, periodo, aluno);

        notaRepository.save(notaEntity);

        return notaModelMapper.convertToNota(notaEntity);
    }

    @Transactional
    public Nota updateNota(Nota nota) {
        var disciplina = getDisciplina( nota.getDisciplina().getIdDisciplina());
        var periodo = getPeriodo(nota.getPeriodo().getIdPeriodo());
        var aluno = getAluno(nota.getAlunoId());

        NotaEntity notaEntity = notaModelMapper.convertToNotaEntity(nota, disciplina, periodo, aluno);

        notaRepository.save(notaEntity);

        return notaModelMapper.convertToNota(notaEntity);
    }

    public void deleteNota(Integer idNota) {
        notaRepository.deleteById(idNota);
    }

    private DisciplinaEntity getDisciplina(Integer disciplinaId){
        return disciplinaRepository.findById( disciplinaId )
                                   .orElseThrow(() -> new RuntimeException("Disciplina não Encontrada!"));
    }

    private PeriodoEntity getPeriodo(Integer periodoId){
        return periodoRepository.findById( periodoId )
                                .orElseThrow(() -> new RuntimeException("Periodo não Encontrado!"));
    }

    private AlunoEntity getAluno(Integer alunoId){
        return alunoRepository.findById( alunoId )
                              .orElseThrow(() -> new RuntimeException("Aluno não Encontrado!"));
    }
}
