package pt.colegio.colibri.business.service;

import org.springframework.stereotype.Service;
import pt.colegio.colibri.business.core.Login;
import pt.colegio.colibri.model.LoginModel;

import java.util.List;

@Service
public class LoginService {

    private final LoginModel loginModel;

    public LoginService(LoginModel loginModel) {
        this.loginModel = loginModel;
    }

    public List<Login> getLogins(){
        return loginModel.getLogins();
    }
}
