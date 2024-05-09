package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pt.colegio.colibri.business.core.Funcionario;
import pt.colegio.colibri.business.service.FuncionarioService;
import pt.colegio.colibri.controller.dtos.request.FuncionarioRequestDTO;
import pt.colegio.colibri.controller.dtos.response.FuncionarioResponseDTO;
import pt.colegio.colibri.controller.mapper.FuncionarioControllerMapper;

import java.util.List;

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
    @ResponseStatus(HttpStatus.OK)
    public List<FuncionarioResponseDTO> getFuncionarios(){
        var funcionarios = funcionarioService.getFuncionarios();

        return funcionarioControllerMapper.convertToFuncionarioDTOList(funcionarios);
    }

    @GetMapping("/{idFuncionario}")
    @ResponseStatus(HttpStatus.OK)
    public FuncionarioResponseDTO getFuncionario(@PathVariable Integer idFuncionario){
        Funcionario funcionario = funcionarioService.getFuncionario(idFuncionario);

        return funcionarioControllerMapper.convertToFuncionarioDTO(funcionario);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FuncionarioResponseDTO addFuncionario(@RequestBody FuncionarioRequestDTO funcionarioRequestDTO){
        Funcionario funcionario = funcionarioControllerMapper.convertToFuncionario(funcionarioRequestDTO);

        Funcionario funcionarioSalvo = funcionarioService.addFuncionario(funcionario);

        return funcionarioControllerMapper.convertToFuncionarioDTO(funcionarioSalvo);
    }

    @PutMapping("/{idFuncionario}")
    @ResponseStatus(HttpStatus.OK)
    public FuncionarioResponseDTO updateFuncionario(@RequestBody FuncionarioRequestDTO funcionarioRequestDTO, @PathVariable Integer idFuncionario){
        Funcionario funcionario = funcionarioControllerMapper.convertToFuncionario(funcionarioRequestDTO, idFuncionario);

        Funcionario funcionarioAtualizado = funcionarioService.updateFuncionario(funcionario);

        return funcionarioControllerMapper.convertToFuncionarioDTO(funcionarioAtualizado);
    }

    @DeleteMapping("/{idFuncionario}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFuncionario(@PathVariable Integer idFuncionario){
        funcionarioService.deleteFuncionario(idFuncionario);
    }
}
