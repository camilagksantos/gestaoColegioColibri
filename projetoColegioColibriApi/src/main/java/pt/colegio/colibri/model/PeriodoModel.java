package pt.colegio.colibri.model;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Periodo;
import pt.colegio.colibri.model.entity.PeriodoEntity;
import pt.colegio.colibri.model.mapper.PeriodoModelMapper;
import pt.colegio.colibri.model.repository.PeriodoRepository;

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
public class PeriodoModel {
    private final PeriodoRepository periodoRepository;
    private final PeriodoModelMapper periodoModelMapper;

    public PeriodoModel(PeriodoRepository periodoRepository, PeriodoModelMapper periodoModelMapper) {
        this.periodoRepository = periodoRepository;
        this.periodoModelMapper = periodoModelMapper;
    }

    public List<Periodo> getPeriodos(){
        var periodoEntity = periodoRepository.findAll();

        return periodoModelMapper.convertToPeriodoList(periodoEntity);
    }

    public Periodo getPeriodo(Integer idPeriodo) {
        PeriodoEntity periodoEntity = periodoRepository.findById(idPeriodo)
                                                       .orElseThrow(() -> new RuntimeException("Registo não Encontrado!"));

        return periodoModelMapper.convertToPeriodo(periodoEntity);
    }

    @Transactional
    public Periodo addPeriodo(Periodo periodo) {
        PeriodoEntity periodoEntity = periodoModelMapper.convertToPeriodoEntity(periodo);

        periodoRepository.save(periodoEntity);

        return periodoModelMapper.convertToPeriodo(periodoEntity);
    }

    @Transactional
    public Periodo updatePeriodo(Periodo periodo) {
        PeriodoEntity periodoEntity = periodoModelMapper.convertToPeriodoEntity(periodo);

        periodoRepository.save(periodoEntity);

        return periodoModelMapper.convertToPeriodo(periodoEntity);
    }

    public void deletePeriodo(Integer idPeriodo) {
        periodoRepository.deleteById(idPeriodo);
    }
}
