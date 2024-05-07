package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pt.colegio.colibri.business.core.Login;
import pt.colegio.colibri.business.service.LoginService;
import pt.colegio.colibri.controller.dtos.request.LoginRequestDTO;
import pt.colegio.colibri.controller.dtos.response.LoginResponseDTO;
import pt.colegio.colibri.controller.mapper.LoginControllerMapper;

import java.util.List;

@RestController
@RequestMapping("/logins")
public class LoginController {

    private final LoginService loginService;
    private final LoginControllerMapper loginControllerMapper;

    public LoginController(LoginService loginService, LoginControllerMapper loginControllerMapper) {
        this.loginService = loginService;
        this.loginControllerMapper = loginControllerMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LoginResponseDTO> getLogins(){
        var logins = loginService.getLogins();

        return loginControllerMapper.convertToLoginDTOList(logins);
    }

    @GetMapping("/{idLogin}")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponseDTO getLogin(@PathVariable Integer idLogin){
        Login login = loginService.getLogin(idLogin);

        return loginControllerMapper.convertToLoginDTO(login);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResponseDTO addLogin(@RequestBody LoginRequestDTO loginRequestDTO){
        Login login = loginControllerMapper.convertToLogin(loginRequestDTO);

        Login loginSalvo = loginService.addLogin(login);

        return loginControllerMapper.convertToLoginDTO(loginSalvo);
    }

    @PutMapping("/{idLogin}")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponseDTO updateLogin(@RequestBody LoginRequestDTO loginRequestDTO, @PathVariable Integer idLogin){
        Login login = loginControllerMapper.convertToLogin(loginRequestDTO, idLogin);

        Login loginAtualizado = loginService.updateLogin(login);

        return loginControllerMapper.convertToLoginDTO(loginAtualizado);
    }

    @DeleteMapping("/{idLogin}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLogin(@PathVariable Integer idLogin){
        loginService.deleteLogin(idLogin);
    }
}
