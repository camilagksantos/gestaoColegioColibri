package pt.colegio.colibri.model;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Login;
import pt.colegio.colibri.model.entity.LoginEntity;
import pt.colegio.colibri.model.mapper.LoginModelMapper;
import pt.colegio.colibri.model.repository.LoginRepository;

import java.util.List;
import java.util.Optional;

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
public class LoginModel {

    private final LoginRepository loginRepository;
    private final LoginModelMapper loginModelMapper;

    public LoginModel(LoginRepository loginRepository, LoginModelMapper loginModelMapper) {
        this.loginRepository = loginRepository;
        this.loginModelMapper = loginModelMapper;
    }

    public List<Login> getLogins() {
        var loginsEntity = loginRepository.findAll();

        return loginModelMapper.convertToLoginList(loginsEntity);
    }

    public Login getLogin(Integer idLogin) {
        LoginEntity loginEntity = loginRepository.findById(idLogin)
                                                 .orElseThrow(() -> new RuntimeException("Registo não Encontrado!"));

        return loginModelMapper.convertToLogin(loginEntity);
    }

    public Login addLogin(Login login) {
        LoginEntity loginEntity = loginModelMapper.convertToLoginEntity(login);

        loginRepository.save(loginEntity);

        return loginModelMapper.convertToLogin(loginEntity);
    }

    public Login updateLogin(Login login) {
        LoginEntity loginEntity = loginModelMapper.convertToLoginEntity(login);

        loginRepository.save(loginEntity);

        return loginModelMapper.convertToLogin(loginEntity);
    }

    public void deleteLogin(Integer idLogin) {
        loginRepository.deleteById(idLogin);
    }

    public Login getLoginByUsername(String username) {
        var loginEntity = loginRepository.findByUsername( username )
                .orElseThrow(() -> new UsernameNotFoundException( "User Not Found with username:"+username ));

        return loginModelMapper.convertToLogin(loginEntity);
    }

    public UserDetails loadUserByUsername(String username ) throws UsernameNotFoundException {
        return loginRepository.findByUsername( username )
                .orElseThrow(() -> new UsernameNotFoundException( "User Not Found with username:"+username ));
    }
}
