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

    public Turma getTurmaByFuncionarioId(Integer id) {
        var turmaEntity = turmaRepository.findByProfessor_IdFuncionario(id);

        return turmaModelMapper.convertToTurma(turmaEntity);
    }
}