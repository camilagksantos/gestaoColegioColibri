package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pt.colegio.colibri.business.core.Disciplina;
import pt.colegio.colibri.business.service.DisciplinaService;
import pt.colegio.colibri.controller.dtos.request.DisciplinaRequestDTO;
import pt.colegio.colibri.controller.dtos.response.DisciplinaResponseDTO;
import pt.colegio.colibri.controller.mapper.DisciplinaControllerMapper;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
    private final DisciplinaService disciplinaService;
    private final DisciplinaControllerMapper disciplinaControllerMapper;

    public DisciplinaController(DisciplinaService disciplinaService, DisciplinaControllerMapper disciplinaControllerMapper) {
        this.disciplinaService = disciplinaService;
        this.disciplinaControllerMapper = disciplinaControllerMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DisciplinaResponseDTO> getDisciplinas(){
        var disciplinas = disciplinaService.getDisciplinas();

        return disciplinaControllerMapper.convertToDisciplinaDTOList(disciplinas);
    }

    @GetMapping("/{idDisciplina}")
    @ResponseStatus(HttpStatus.OK)
    public DisciplinaResponseDTO getDisciplina(@PathVariable Integer idDisciplina){
        Disciplina disciplina = disciplinaService.getDisciplina(idDisciplina);

        return disciplinaControllerMapper.convertToDisciplinaDTO(disciplina);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DisciplinaResponseDTO addDisciplina(@RequestBody DisciplinaRequestDTO disciplinaRequestDTO){
        Disciplina disciplina = disciplinaControllerMapper.convertToDisciplina(disciplinaRequestDTO);

        Disciplina disciplinaSalvo = disciplinaService.addDisciplina(disciplina);

        return disciplinaControllerMapper.convertToDisciplinaDTO(disciplinaSalvo);
    }

    @PutMapping("/{idDisciplina}")
    @ResponseStatus(HttpStatus.OK)
    public DisciplinaResponseDTO updateDisciplina(@RequestBody DisciplinaRequestDTO disciplinaRequestDTO, @PathVariable Integer idDisciplina){
        Disciplina disciplina = disciplinaControllerMapper.convertToDisciplina(disciplinaRequestDTO, idDisciplina);

        Disciplina disciplinaAtualizado = disciplinaService.updateDisciplina(disciplina);

        return disciplinaControllerMapper.convertToDisciplinaDTO(disciplinaAtualizado);
    }

    @DeleteMapping("/{idDisciplina}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDisciplina(@PathVariable Integer idDisciplina){
        disciplinaService.deleteDisciplina(idDisciplina);
    }
}
