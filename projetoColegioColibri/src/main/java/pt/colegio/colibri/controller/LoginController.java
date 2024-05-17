package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pt.colegio.colibri.business.core.Login;
import pt.colegio.colibri.business.service.LoginService;
import pt.colegio.colibri.controller.dtos.request.LoginRequestDTO;
import pt.colegio.colibri.controller.dtos.response.LoginResponseDTO;
import pt.colegio.colibri.controller.mapper.LoginControllerMapper;

import java.util.List;

//Este código define um controlador LoginController em uma aplicação Spring Boot, que é responsável por manipular
// requisições HTTP relacionadas aos logins de um sistema. O controlador é anotado com @RestController,
// indicando que ele é um controlador RESTful, e @RequestMapping("/login"), que define o caminho base para todas as
// rotas definidas neste controlador.

//Todas as rotas são protegidas pela anotação @PreAuthorize, que verifica se o usuário autenticado tem a permissão
// adequada para acessar ou modificar os recursos. Por exemplo, apenas usuários com a função de Administrador podem
// acessar os métodos de leitura, enquanto apenas Administradores podem adicionar, atualizar ou deletar logins.

//A anotação @ResponseStatus é usada para especificar o código de status HTTP que deve ser retornado após a execução
// bem-sucedida de uma operação. Por exemplo, HttpStatus.OK indica sucesso na operação.

//Este controlador exemplifica como o Spring Boot facilita a criação de APIs RESTful seguras e eficientes, utilizando
// injeção de dependência, mapeamento de DTOs e anotações de segurança.

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
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public List<LoginResponseDTO> getLogins(){
        var logins = loginService.getLogins();
        return loginControllerMapper.convertToLoginDTOList(logins);
    }

    @GetMapping("/{idLogin}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponseDTO getLogin(@PathVariable Integer idLogin){
        Login login = loginService.getLogin(idLogin);
        return loginControllerMapper.convertToLoginDTO(login);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResponseDTO addLogin(@RequestBody LoginRequestDTO loginRequestDTO){
        Login login = loginControllerMapper.convertToLogin(loginRequestDTO);

        Login loginSalvo = loginService.addLogin(login);

        return loginControllerMapper.convertToLoginDTO(loginSalvo);
    }

    @PutMapping("/{idLogin}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponseDTO updateLogin(@RequestBody LoginRequestDTO loginRequestDTO, @PathVariable Integer idLogin){
        Login login = loginControllerMapper.convertToLogin(loginRequestDTO, idLogin);

        Login loginAtualizado = loginService.updateLogin(login);

        return loginControllerMapper.convertToLoginDTO(loginAtualizado);
    }

    @DeleteMapping("/{idLogin}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLogin(@PathVariable Integer idLogin){
        loginService.deleteLogin(idLogin);
    }
}