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
