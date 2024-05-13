package pt.colegio.colibri.business.service;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import pt.colegio.colibri.business.core.Login;
import pt.colegio.colibri.model.LoginModel;

import java.util.List;

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
