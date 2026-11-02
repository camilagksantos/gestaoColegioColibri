package pt.colegio.colibri.business.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pt.colegio.colibri.business.core.Login;
import pt.colegio.colibri.model.LoginModel;

import java.util.List;

//Este código é parte de uma aplicação Spring Boot, especificamente uma classe de serviço (LoginService) que interage
// com um modelo de dados (Login) para realizar operações CRUD (Create, Read, Update, Delete) relacionadas a
// "logins" ou sessões de login de usuários.

//A classe é anotada com @Service, marcando-a como um componente de serviço no Spring. Isso significa que o Spring
// pode gerenciar instâncias desta classe automaticamente. A anotação @AllArgsConstructor do Lombok gera um construtor
// com todos os campos como parâmetros, permitindo a injeção de dependências sem a necessidade de definir
// explicitamente o construtor.

@Service
@AllArgsConstructor
public class LoginService {

    private final LoginModel loginModel;

    public List<Login> getLogins(){
        return loginModel.getLogins();
    }

    public Login getLogin(Integer idLogin) {
        return loginModel.getLogin(idLogin);
    }

    public Login addLogin(Login login) {
        return loginModel.addLogin(login);
    }

    public Login updateLogin(Login login) {
        return loginModel.updateLogin(login);
    }

    public void deleteLogin(Integer idLogin) {
        loginModel.deleteLogin(idLogin);
    }
}
