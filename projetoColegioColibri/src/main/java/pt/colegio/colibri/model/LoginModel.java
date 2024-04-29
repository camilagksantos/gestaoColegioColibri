package pt.colegio.colibri.model;

import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Login;
import pt.colegio.colibri.model.mapper.LoginModelMapper;
import pt.colegio.colibri.model.repository.LoginRepository;

import java.util.List;

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
}
