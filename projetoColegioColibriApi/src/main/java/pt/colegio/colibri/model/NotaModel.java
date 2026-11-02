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

import java.util.Collection;
import java.util.List;

//Esta classe é um componente Spring Boot que atua como um serviço para gerenciar entidades de turma em uma
// aplicação Java Maven. Ela utiliza Lombok para simplificar a escrita de código, como a anotação @Component para
// indicar que é um bean gerenciável pelo Spring, e @Transactional para garantir que as operações de banco de dados
// sejam tratadas como transações.

//@Component: Indica que a classe é um bean gerenciável pelo Spring, permitindo que ela seja automaticamente detectada
// e instanciada pelo framework.

//@Transactional: Garante que as operações de adição e atualização de turmas sejam tratadas como transações, o que é
// crucial para a integridade dos dados.

//A classe segue o padrão de injeção de dependências, o que é uma prática recomendada para desacoplar a lógica de
// negócios da infraestrutura.

//Esta classe é um exemplo de como o Spring Boot, juntamente com Lombok e boas práticas de design, pode ser utilizado
// para criar aplicações robustas e escaláveis.

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

    public List<Nota> getNotasByAlunoId(Integer id) {
        var notasEntity = notaRepository.findByAluno_IdAluno(id);

        return notaModelMapper.convertToNotaList(notasEntity);
    }
}
