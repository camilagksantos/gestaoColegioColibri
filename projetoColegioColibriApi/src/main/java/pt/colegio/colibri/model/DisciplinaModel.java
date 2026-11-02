package pt.colegio.colibri.model;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Disciplina;
import pt.colegio.colibri.model.entity.DisciplinaEntity;
import pt.colegio.colibri.model.mapper.DisciplinaModelMapper;
import pt.colegio.colibri.model.repository.DisciplinaRepository;

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
                                                                .orElseThrow(() -> new RuntimeException("Disciplina não Encontrada!"));

        return disciplinaModelMapper.convertToDisciplina(disciplinaEntity);
    }

    @Transactional
    public Disciplina addDisciplina(Disciplina disciplina) {
        DisciplinaEntity disciplinaEntity = disciplinaModelMapper.convertToDisciplinaEntity(disciplina);

        disciplinaRepository.save(disciplinaEntity);

        return disciplinaModelMapper.convertToDisciplina(disciplinaEntity);
    }

    @Transactional
    public Disciplina updateDisciplina(Disciplina disciplina) {
        DisciplinaEntity disciplinaEntity = disciplinaModelMapper.convertToDisciplinaEntity(disciplina);

        disciplinaRepository.save(disciplinaEntity);

        return disciplinaModelMapper.convertToDisciplina(disciplinaEntity);
    }

    public void deleteDisciplina(Integer idDisciplina) {
        disciplinaRepository.deleteById(idDisciplina);
    }
}
