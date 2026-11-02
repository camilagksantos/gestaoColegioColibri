package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pt.colegio.colibri.business.core.Aluno;
import pt.colegio.colibri.business.service.AlunoService;
import pt.colegio.colibri.controller.dtos.request.AlunoRequestDTO;
import pt.colegio.colibri.controller.dtos.response.AlunoResponseDTO;
import pt.colegio.colibri.controller.mapper.AlunoControllerMapper;

import java.util.List;

//Este código define um controlador AlunoController em uma aplicação Spring Boot, que é responsável por manipular
// requisições HTTP relacionadas aos alunos de um sistema educacional. O controlador é anotado com @RestController,
// indicando que ele é um controlador RESTful, e @RequestMapping("/alunos"), que define o caminho base para todas as
// rotas definidas neste controlador.

//Todas as rotas são protegidas pela anotação @PreAuthorize, que verifica se o usuário autenticado tem a permissão
// adequada para acessar ou modificar os recursos. Por exemplo, apenas usuários com a função de Diretor ou Professor
// podem acessar os métodos de leitura, enquanto apenas Diretores podem adicionar, atualizar ou deletar alunos.

//A anotação @ResponseStatus é usada para especificar o código de status HTTP que deve ser retornado após a execução
// bem-sucedida de uma operação. Por exemplo, HttpStatus.OK indica sucesso na operação.

//Este controlador exemplifica como o Spring Boot facilita a criação de APIs RESTful seguras e eficientes, utilizando
// injeção de dependência, mapeamento de DTOs e anotações de segurança.

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;
    private final AlunoControllerMapper alunoControllerMapper;

    public AlunoController(AlunoService alunoService, AlunoControllerMapper alunoControllerMapper) {
        this.alunoService = alunoService;
        this.alunoControllerMapper = alunoControllerMapper;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR', 'ROLE_PROFESSOR', 'ROLE_ALUNO')")
    @ResponseStatus(HttpStatus.OK)
    public List<AlunoResponseDTO> getAlunos(){
        var alunos = alunoService.getAlunos();

        return alunoControllerMapper.convertToAlunoDTOList(alunos);
    }

    @GetMapping("/{idAluno}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR', 'ROLE_PROFESSOR', 'ROLE_ALUNO')")
    @ResponseStatus(HttpStatus.OK)
    public AlunoResponseDTO getAluno(@PathVariable Integer idAluno){
        Aluno aluno = alunoService.getAluno(idAluno);

        return alunoControllerMapper.convertToAlunoDTO(aluno);
    }

    @PostMapping@PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoResponseDTO addAluno(@RequestBody AlunoRequestDTO alunoRequestDTO){
        Aluno aluno = alunoControllerMapper.convertToAluno(alunoRequestDTO);

        Aluno alunoSalvo = alunoService.addAluno(aluno);

        return alunoControllerMapper.convertToAlunoDTO(alunoSalvo);
    }

    @PutMapping("/{idAluno}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public AlunoResponseDTO updateAluno(@RequestBody AlunoRequestDTO alunoRequestDTO, @PathVariable Integer idAluno){
        Aluno aluno = alunoControllerMapper.convertToAluno(alunoRequestDTO, idAluno);

        Aluno alunoAtualizado = alunoService.updateAluno(aluno);

        return alunoControllerMapper.convertToAlunoDTO(alunoAtualizado);
    }

    @DeleteMapping("/{idAluno}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAluno(@PathVariable Integer idAluno){
        alunoService.deleteAluno(idAluno);
    }
}