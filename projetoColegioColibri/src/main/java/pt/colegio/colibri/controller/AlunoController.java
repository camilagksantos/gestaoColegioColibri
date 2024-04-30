package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pt.colegio.colibri.business.service.AlunoService;
import pt.colegio.colibri.controller.dtos.AlunoDTO;
import pt.colegio.colibri.controller.mapper.AlunoControllerMapper;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;
    private final AlunoControllerMapper alunoControllerMapper;

    public AlunoController(AlunoService alunoService, AlunoControllerMapper alunoControllerMapper) {
        this.alunoService = alunoService;
        this.alunoControllerMapper = alunoControllerMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlunoDTO> getAlunos(){
        var alunos = alunoService.getAlunos();
        return alunoControllerMapper.convertToAlunoDTOList(alunos);
    }
}
