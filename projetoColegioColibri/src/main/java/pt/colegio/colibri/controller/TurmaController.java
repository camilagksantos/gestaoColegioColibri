package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pt.colegio.colibri.business.core.Turma;
import pt.colegio.colibri.business.service.TurmaService;
import pt.colegio.colibri.controller.dtos.request.TurmaRequestDTO;
import pt.colegio.colibri.controller.dtos.response.TurmaResponseDTO;
import pt.colegio.colibri.controller.mapper.TurmaControllerMapper;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaService turmaService;
    private final TurmaControllerMapper turmaControllerMapper;

    public TurmaController(TurmaService turmaService, TurmaControllerMapper turmaControllerMapper) {
        this.turmaService = turmaService;
        this.turmaControllerMapper = turmaControllerMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TurmaResponseDTO> getTurmas(){
        var turmas = turmaService.getTurmas();
        return turmaControllerMapper.convertToTurmaDTOList(turmas);
    }

    @GetMapping("/{idTurma}")
    @ResponseStatus(HttpStatus.OK)
    public TurmaResponseDTO getTurma(@PathVariable Integer idTurma){
        Turma turma = turmaService.getTurma(idTurma);

        return turmaControllerMapper.convertToTurmaDTO(turma);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TurmaResponseDTO addTurma(@RequestBody TurmaRequestDTO turmaRequestDTO){
        Turma turma = turmaControllerMapper.convertToTurma(turmaRequestDTO);

        Turma turmaSalvo = turmaService.addTurma(turma);

        return turmaControllerMapper.convertToTurmaDTO(turmaSalvo);
    }

    @PutMapping("/{idTurma}")
    @ResponseStatus(HttpStatus.OK)
    public TurmaResponseDTO updateTurma(@RequestBody TurmaRequestDTO turmaRequestDTO, @PathVariable Integer idTurma){
        Turma turma = turmaControllerMapper.convertToTurma(turmaRequestDTO, idTurma);

        Turma turmaAtualizado = turmaService.updateTurma(turma);

        return turmaControllerMapper.convertToTurmaDTO(turmaAtualizado);
    }

    @DeleteMapping("/{idTurma}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTurma(@PathVariable Integer idTurma){
        turmaService.deleteTurma(idTurma);
    }
}
