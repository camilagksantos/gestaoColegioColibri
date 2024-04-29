package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pt.colegio.colibri.business.service.LoginService;
import pt.colegio.colibri.controller.dtos.LoginDTO;
import pt.colegio.colibri.controller.mapper.LoginControllerMapper;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;
    private final LoginControllerMapper loginControllerMapper;

    public LoginController(LoginService loginService, LoginControllerMapper loginControllerMapper) {
        this.loginService = loginService;
        this.loginControllerMapper = loginControllerMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LoginDTO> getLogins(){
        var logins = loginService.getLogins();

        return loginControllerMapper.convertToLoginDTOList(logins);
    }
}
