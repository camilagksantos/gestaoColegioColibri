package pt.colegio.colibri.model;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Funcionario;
import pt.colegio.colibri.model.entity.FuncionarioEntity;
import pt.colegio.colibri.model.entity.LoginEntity;
import pt.colegio.colibri.model.mapper.FuncionarioModelMapper;
import pt.colegio.colibri.model.repository.FuncionarioRepository;
import pt.colegio.colibri.model.repository.LoginRepository;

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
public class FuncionarioModel {
    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioModelMapper funcionarioModelMapper;
    private final LoginRepository loginRepository;

    public FuncionarioModel(FuncionarioRepository funcionarioRepository, FuncionarioModelMapper funcionarioModelMapper, LoginRepository loginRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioModelMapper = funcionarioModelMapper;
        this.loginRepository = loginRepository;
    }

    public List<Funcionario> getFuncionarios() {
        var funcioanriosEntity = funcionarioRepository.findAll();

        return funcionarioModelMapper.convertToFuncionarioList(funcioanriosEntity);
    }

    public Funcionario getFuncionario(Integer idFuncionario) {
        FuncionarioEntity funcionarioEntity = funcionarioRepository.findById(idFuncionario)
                                                                   .orElseThrow(() -> new RuntimeException("Registo não Encontrado!"));

        return funcionarioModelMapper.convertToFuncionario(funcionarioEntity);
    }

    @Transactional
    public Funcionario addFuncionario(Funcionario funcionario) {
        var login = getLogin( funcionario.getLogin().getIdLogin());

        FuncionarioEntity funcionarioEntity = funcionarioModelMapper.convertToFuncionarioEntity(funcionario, login);

        funcionarioRepository.save(funcionarioEntity);

        return funcionarioModelMapper.convertToFuncionario(funcionarioEntity);
    }

    @Transactional
    public Funcionario updateFuncionario(Funcionario funcionario) {
        var login = getLogin( funcionario.getLogin().getIdLogin());

        FuncionarioEntity funcionarioEntity = funcionarioModelMapper.convertToFuncionarioEntity(funcionario, login);

        funcionarioRepository.save(funcionarioEntity);

        return funcionarioModelMapper.convertToFuncionario(funcionarioEntity);
    }

    public void deleteFuncionario(Integer idFuncionario) {
        funcionarioRepository.deleteById(idFuncionario);
    }

    private LoginEntity getLogin(Integer loginId){
        return loginRepository.findById(loginId)
                              .orElseThrow(() -> new RuntimeException("Login não Encontrado!"));
    }

    public Funcionario getFuncionarioByLoginId(Integer idLogin) {
        var funcionarioEntity = funcionarioRepository.findByLogin_IdLogin(idLogin);

        return funcionarioModelMapper.convertToFuncionario(funcionarioEntity);
    }
}
