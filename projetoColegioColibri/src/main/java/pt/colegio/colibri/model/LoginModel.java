package pt.colegio.colibri.model;

import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Login;
import pt.colegio.colibri.model.entity.LoginEntity;
import pt.colegio.colibri.model.mapper.LoginModelMapper;
import pt.colegio.colibri.model.repository.LoginRepository;

import java.util.List;
import java.util.Optional;

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
}
