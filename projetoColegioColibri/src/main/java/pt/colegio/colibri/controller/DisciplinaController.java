package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pt.colegio.colibri.business.service.DisciplinaService;
import pt.colegio.colibri.controller.dtos.DisciplinaDTO;
import pt.colegio.colibri.controller.mapper.DisciplinaControllerMapper;

import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;
    private final DisciplinaControllerMapper disciplinaControllerMapper;

    public DisciplinaController(DisciplinaService disciplinaService, DisciplinaControllerMapper disciplinaControllerMapper) {
        this.disciplinaService = disciplinaService;
        this.disciplinaControllerMapper = disciplinaControllerMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DisciplinaDTO> getDisciplinas(){
        var disciplinas = disciplinaService.getDisciplinas();
        return disciplinaControllerMapper.convertToDisciplinaDTOList(disciplinas);
    }
}
