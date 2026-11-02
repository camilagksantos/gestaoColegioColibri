package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pt.colegio.colibri.business.core.Funcionario;
import pt.colegio.colibri.business.service.FuncionarioService;
import pt.colegio.colibri.controller.dtos.request.FuncionarioRequestDTO;
import pt.colegio.colibri.controller.dtos.response.FuncionarioResponseDTO;
import pt.colegio.colibri.controller.mapper.FuncionarioControllerMapper;

import java.util.List;

// Este código define um controlador FuncionarioController em uma aplicação Spring Boot, que é responsável por manipular
// requisições HTTP relacionadas aos funcionários de um sistema organizacional. O controlador é anotado com @RestController,
// indicando que ele é um controlador RESTful, e @RequestMapping("/funcionarios"), que define o caminho base para todas as
// rotas definidas neste controlador.

// Todas as rotas são protegidas pela anotação @PreAuthorize, que verifica se o usuário autenticado tem a permissão
// adequada para acessar ou modificar os recursos. Por exemplo, apenas usuários com a função de Diretor ou Gerente
// podem acessar os métodos de leitura, enquanto apenas Diretores podem adicionar, atualizar ou deletar funcionários.

// A anotação @ResponseStatus é usada para especificar o código de status HTTP que deve ser retornado após a execução
// bem-sucedida de uma operação. Por exemplo, HttpStatus.OK indica sucesso na operação.

// Este controlador exemplifica como o Spring Boot facilita a criação de APIs RESTful seguras e eficientes, utilizando
// injeção de dependência, mapeamento de DTOs e anotações de segurança.

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;
    private final FuncionarioControllerMapper funcionarioControllerMapper;

    public FuncionarioController(FuncionarioService funcionarioService, FuncionarioControllerMapper funcionarioControllerMapper) {
        this.funcionarioService = funcionarioService;
        this.funcionarioControllerMapper = funcionarioControllerMapper;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public List<FuncionarioResponseDTO> getFuncionarios(){
        var funcionarios = funcionarioService.getFuncionarios();

        return funcionarioControllerMapper.convertToFuncionarioDTOList(funcionarios);
    }

    @GetMapping("/{idFuncionario}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public FuncionarioResponseDTO getFuncionario(@PathVariable Integer idFuncionario){
        Funcionario funcionario = funcionarioService.getFuncionario(idFuncionario);

        return funcionarioControllerMapper.convertToFuncionarioDTO(funcionario);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.CREATED)
    public FuncionarioResponseDTO addFuncionario(@RequestBody FuncionarioRequestDTO funcionarioRequestDTO){
        Funcionario funcionario = funcionarioControllerMapper.convertToFuncionario(funcionarioRequestDTO);

        Funcionario funcionarioSalvo = funcionarioService.addFuncionario(funcionario);

        return funcionarioControllerMapper.convertToFuncionarioDTO(funcionarioSalvo);
    }

    @PutMapping("/{idFuncionario}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public FuncionarioResponseDTO updateFuncionario(@RequestBody FuncionarioRequestDTO funcionarioRequestDTO, @PathVariable Integer idFuncionario){
        Funcionario funcionario = funcionarioControllerMapper.convertToFuncionario(funcionarioRequestDTO, idFuncionario);

        Funcionario funcionarioAtualizado = funcionarioService.updateFuncionario(funcionario);

        return funcionarioControllerMapper.convertToFuncionarioDTO(funcionarioAtualizado);
    }

    @DeleteMapping("/{idFuncionario}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFuncionario(@PathVariable Integer idFuncionario){
        funcionarioService.deleteFuncionario(idFuncionario);
    }
}