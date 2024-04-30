package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pt.colegio.colibri.business.service.FuncionarioService;
import pt.colegio.colibri.controller.dtos.FuncionarioDTO;
import pt.colegio.colibri.controller.mapper.FuncionarioControllerMapper;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {


    private final FuncionarioService funcionarioService;
    private final FuncionarioControllerMapper funcionarioControllerMapper;

    public FuncionarioController(FuncionarioService funcionarioService, FuncionarioControllerMapper funcionarioControllerMapper) {
        this.funcionarioService = funcionarioService;
        this.funcionarioControllerMapper = funcionarioControllerMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FuncionarioDTO> getFuncionarios(){
        var funcionarios = funcionarioService.getFuncionarios();
        return funcionarioControllerMapper.convertToFuncionarioDTOList(funcionarios);
    }
}
