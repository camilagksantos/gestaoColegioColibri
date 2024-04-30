package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pt.colegio.colibri.business.service.TurmaService;
import pt.colegio.colibri.controller.dtos.TurmaDTO;
import pt.colegio.colibri.controller.mapper.TurmaControllerMapper;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    private final TurmaService turmaService;
    private final TurmaControllerMapper turmaControllerMapper;

    public TurmaController(TurmaService turmaService, TurmaControllerMapper turmaControllerMapper) {
        this.turmaService = turmaService;
        this.turmaControllerMapper = turmaControllerMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TurmaDTO> getTurmas(){
        var turmas = turmaService.getTurmas();
        return turmaControllerMapper.convertToTurmaDTOList(turmas);
    }
}
