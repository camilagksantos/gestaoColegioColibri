package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pt.colegio.colibri.business.core.Disciplina;
import pt.colegio.colibri.business.service.DisciplinaService;
import pt.colegio.colibri.controller.dtos.request.DisciplinaRequestDTO;
import pt.colegio.colibri.controller.dtos.response.DisciplinaResponseDTO;
import pt.colegio.colibri.controller.mapper.DisciplinaControllerMapper;

import java.util.List;

// Este código define um controlador DisciplinaController em uma aplicação Spring Boot, que é responsável por manipular
// requisições HTTP relacionadas às disciplinas de um sistema educacional. O controlador é anotado com @RestController,
// indicando que ele é um controlador RESTful, e @RequestMapping("/disciplinas"), que define o caminho base para todas as
// rotas definidas neste controlador.

// Todas as rotas são protegidas pela anotação @PreAuthorize, que verifica se o usuário autenticado tem a permissão
// adequada para acessar ou modificar os recursos. Por exemplo, apenas usuários com a função de Diretor ou Professor
// podem acessar os métodos de leitura, enquanto apenas Diretores podem adicionar, atualizar ou deletar disciplinas.

// A anotação @ResponseStatus é usada para especificar o código de status HTTP que deve ser retornado após a execução
// bem-sucedida de uma operação. Por exemplo, HttpStatus.OK indica sucesso na operação.

// Este controlador exemplifica como o Spring Boot facilita a criação de APIs RESTful seguras e eficientes, utilizando
// injeção de dependência, mapeamento de DTOs e anotações de segurança.

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
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public List<DisciplinaResponseDTO> getDisciplinas(){
        var disciplinas = disciplinaService.getDisciplinas();

        return disciplinaControllerMapper.convertToDisciplinaDTOList(disciplinas);
    }

    @GetMapping("/{idDisciplina}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public DisciplinaResponseDTO getDisciplina(@PathVariable Integer idDisciplina){
        Disciplina disciplina = disciplinaService.getDisciplina(idDisciplina);

        return disciplinaControllerMapper.convertToDisciplinaDTO(disciplina);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.CREATED)
    public DisciplinaResponseDTO addDisciplina(@RequestBody DisciplinaRequestDTO disciplinaRequestDTO){
        Disciplina disciplina = disciplinaControllerMapper.convertToDisciplina(disciplinaRequestDTO);

        Disciplina disciplinaSalvo = disciplinaService.addDisciplina(disciplina);

        return disciplinaControllerMapper.convertToDisciplinaDTO(disciplinaSalvo);
    }

    @PutMapping("/{idDisciplina}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public DisciplinaResponseDTO updateDisciplina(@RequestBody DisciplinaRequestDTO disciplinaRequestDTO, @PathVariable Integer idDisciplina){
        Disciplina disciplina = disciplinaControllerMapper.convertToDisciplina(disciplinaRequestDTO, idDisciplina);

        Disciplina disciplinaAtualizado = disciplinaService.updateDisciplina(disciplina);

        return disciplinaControllerMapper.convertToDisciplinaDTO(disciplinaAtualizado);
    }

    @DeleteMapping("/{idDisciplina}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDisciplina(@PathVariable Integer idDisciplina){
        disciplinaService.deleteDisciplina(idDisciplina);
    }
}