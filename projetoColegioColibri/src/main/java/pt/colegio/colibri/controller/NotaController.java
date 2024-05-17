package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pt.colegio.colibri.business.core.Nota;
import pt.colegio.colibri.business.service.NotaService;
import pt.colegio.colibri.controller.dtos.request.NotaRequestDTO;
import pt.colegio.colibri.controller.dtos.response.NotaResponseDTO;
import pt.colegio.colibri.controller.mapper.NotaControllerMapper;

import java.util.List;

//Este código define um controlador NotaController em uma aplicação Spring Boot, que é responsável por manipular
// requisições HTTP relacionadas às notas de um sistema educacional. O controlador é anotado com @RestController,
// indicando que ele é um controlador RESTful, e @RequestMapping("/notas"), que define o caminho base para todas as
// rotas definidas neste controlador.

//Todas as rotas são protegidas pela anotação @PreAuthorize, que verifica se o usuário autenticado tem a permissão
// adequada para acessar ou modificar os recursos. Por exemplo, apenas usuários com a função de Diretor ou Professor
// podem acessar os métodos de leitura, enquanto apenas Diretores podem adicionar, atualizar ou deletar notas.

//A anotação @ResponseStatus é usada para especificar o código de status HTTP que deve ser retornado após a execução
// bem-sucedida de uma operação. Por exemplo, HttpStatus.OK indica sucesso na operação.

//Este controlador exemplifica como o Spring Boot facilita a criação de APIs RESTful seguras e eficientes, utilizando
// injeção de dependência, mapeamento de DTOs e anotações de segurança.

@RestController
@RequestMapping("/notas")
public class NotaController {
    private final NotaService notaService;
    private final NotaControllerMapper notaControllerMapper;

    public NotaController(NotaService notaService, NotaControllerMapper notaControllerMapper) {
        this.notaService = notaService;
        this.notaControllerMapper = notaControllerMapper;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR', 'ROLE_PROFESSOR', 'ROLE_ALUNO')")
    @ResponseStatus(HttpStatus.OK)
    public List<NotaResponseDTO> getNotas(){
        var notas = notaService.getNotas();

        return notaControllerMapper.convertToNotaDTOList(notas);
    }

    @GetMapping("/{idNota}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR', 'ROLE_PROFESSOR', 'ROLE_ALUNO')")
    @ResponseStatus(HttpStatus.OK)
    public NotaResponseDTO getNota(@PathVariable Integer idNota){
        Nota nota = notaService.getNota(idNota);

        return notaControllerMapper.convertToNotaDTO(nota);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR', 'ROLE_PROFESSOR')")
    @ResponseStatus(HttpStatus.CREATED)
    public NotaResponseDTO addNota(@RequestBody NotaRequestDTO notaRequestDTO){
        Nota nota = notaControllerMapper.convertToNota(notaRequestDTO);

        Nota notaSalvo = notaService.addNota(nota);

        return notaControllerMapper.convertToNotaDTO(notaSalvo);
    }

    @PutMapping("/{idNota}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR', 'ROLE_PROFESSOR')")
    @ResponseStatus(HttpStatus.OK)
    public NotaResponseDTO updateNota(@RequestBody NotaRequestDTO notaRequestDTO, @PathVariable Integer idNota){
        Nota nota = notaControllerMapper.convertToNota(notaRequestDTO, idNota);

        Nota notaAtualizado = notaService.updateNota(nota);

        return notaControllerMapper.convertToNotaDTO(notaAtualizado);
    }

    @DeleteMapping("/{idNota}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR', 'ROLE_PROFESSOR')")
    @ResponseStatus(HttpStatus.OK)
    public void deleteNota(@PathVariable Integer idNota){
        notaService.deleteNota(idNota);
    }
}