package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pt.colegio.colibri.business.core.Aluno;
import pt.colegio.colibri.business.service.AlunoService;
import pt.colegio.colibri.controller.dtos.request.AlunoRequestDTO;
import pt.colegio.colibri.controller.dtos.response.AlunoResponseDTO;
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
    public List<AlunoResponseDTO> getAlunos(){
        var alunos = alunoService.getAlunos();
        return alunoControllerMapper.convertToAlunoDTOList(alunos);
    }

    @GetMapping("/{idAluno}")
    @ResponseStatus(HttpStatus.OK)
    public AlunoResponseDTO getAluno(@PathVariable Integer idAluno){
        Aluno aluno = alunoService.getAluno(idAluno);

        return alunoControllerMapper.convertToAlunoDTO(aluno);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoResponseDTO addAluno(@RequestBody AlunoRequestDTO alunoRequestDTO){
        Aluno aluno = alunoControllerMapper.convertToAluno(alunoRequestDTO);

        Aluno alunoSalvo = alunoService.addAluno(aluno);

        return alunoControllerMapper.convertToAlunoDTO(alunoSalvo);
    }

    @PutMapping("/{idAluno}")
    @ResponseStatus(HttpStatus.OK)
    public AlunoResponseDTO updateAluno(@RequestBody AlunoRequestDTO alunoRequestDTO, @PathVariable Integer idAluno){
        Aluno aluno = alunoControllerMapper.convertToAluno(alunoRequestDTO, idAluno);

        Aluno alunoAtualizado = alunoService.updateAluno(aluno);

        return alunoControllerMapper.convertToAlunoDTO(alunoAtualizado);
    }

    @DeleteMapping("/{idAluno}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAluno(@PathVariable Integer idAluno){
        alunoService.deleteAluno(idAluno);
    }
}
