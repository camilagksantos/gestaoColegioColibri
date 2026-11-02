package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pt.colegio.colibri.business.core.Turma;
import pt.colegio.colibri.business.service.TurmaService;
import pt.colegio.colibri.controller.dtos.request.TurmaRequestDTO;
import pt.colegio.colibri.controller.dtos.response.TurmaResponseDTO;
import pt.colegio.colibri.controller.mapper.TurmaControllerMapper;

import java.util.List;

// Este código define um controlador TurmaController em uma aplicação Spring Boot, que é responsável por manipular
// requisições HTTP relacionadas às turmas de um sistema educacional. O controlador é anotado com @RestController,
// indicando que ele é um controlador RESTful, e @RequestMapping("/turmas"), que define o caminho base para todas as
// rotas definidas neste controlador.

// Todas as rotas são protegidas pela anotação @PreAuthorize, que verifica se o usuário autenticado tem a permissão
// adequada para acessar ou modificar os recursos. Por exemplo, apenas usuários com a função de Diretor ou Professor
// podem acessar os métodos de leitura, enquanto apenas Diretores podem adicionar, atualizar ou deletar turmas.

// A anotação @ResponseStatus é usada para especificar o código de status HTTP que deve ser retornado após a execução
// bem-sucedida de uma operação. Por exemplo, HttpStatus.OK indica sucesso na operação.

// Este controlador exemplifica como o Spring Boot facilita a criação de APIs RESTful seguras e eficientes, utilizando
// injeção de dependência, mapeamento de DTOs e anotações de segurança.

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
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public List<TurmaResponseDTO> getTurmas(){
        var turmas = turmaService.getTurmas();

        return turmaControllerMapper.convertToTurmaDTOList(turmas);
    }

    @GetMapping("/{idTurma}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public TurmaResponseDTO getTurma(@PathVariable Integer idTurma){
        Turma turma = turmaService.getTurma(idTurma);

        return turmaControllerMapper.convertToTurmaDTO(turma);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.CREATED)
    public TurmaResponseDTO addTurma(@RequestBody TurmaRequestDTO turmaRequestDTO){
        Turma turma = turmaControllerMapper.convertToTurma(turmaRequestDTO);

        Turma turmaSalvo = turmaService.addTurma(turma);

        return turmaControllerMapper.convertToTurmaDTO(turmaSalvo);
    }

    @PutMapping("/{idTurma}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public TurmaResponseDTO updateTurma(@RequestBody TurmaRequestDTO turmaRequestDTO, @PathVariable Integer idTurma){
        Turma turma = turmaControllerMapper.convertToTurma(turmaRequestDTO, idTurma);

        Turma turmaAtualizado = turmaService.updateTurma(turma);

        return turmaControllerMapper.convertToTurmaDTO(turmaAtualizado);
    }

    @DeleteMapping("/{idTurma}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTurma(@PathVariable Integer idTurma){
        turmaService.deleteTurma(idTurma);
    }
}