package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pt.colegio.colibri.business.core.Periodo;
import pt.colegio.colibri.business.service.PeriodoService;
import pt.colegio.colibri.controller.dtos.request.PeriodoRequestDTO;
import pt.colegio.colibri.controller.dtos.response.PeriodoResponseDTO;
import pt.colegio.colibri.controller.mapper.PeriodoControllerMapper;

import java.util.List;

//Este código define um controlador PeriodoController em uma aplicação Spring Boot, que é responsável por manipular
// requisições HTTP relacionadas aos períodos de um sistema educacional. O controlador é anotado com @RestController,
// indicando que ele é um controlador RESTful, e @RequestMapping("/periodos"), que define o caminho base para todas as
// rotas definidas neste controlador.

//Todas as rotas são protegidas pela anotação @PreAuthorize, que verifica se o usuário autenticado tem a permissão
// adequada para acessar ou modificar os recursos. Por exemplo, apenas usuários com a função de Diretor ou Professor
// podem acessar os métodos de leitura, enquanto apenas Diretores podem adicionar, atualizar ou deletar períodos.

//A anotação @ResponseStatus é usada para especificar o código de status HTTP que deve ser retornado após a execução
// bem-sucedida de uma operação. Por exemplo, HttpStatus.OK indica sucesso na operação.

//Este controlador exemplifica como o Spring Boot facilita a criação de APIs RESTful seguras e eficientes, utilizando
// injeção de dependência, mapeamento de DTOs e anotações de segurança.

@RestController
@RequestMapping("/periodos")
public class PeriodoController {
    private final PeriodoService periodoService;
    private final PeriodoControllerMapper periodoControllerMapper;

    public PeriodoController(PeriodoService periodoService, PeriodoControllerMapper periodoControllerMapper) {
        this.periodoService = periodoService;
        this.periodoControllerMapper = periodoControllerMapper;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public List<PeriodoResponseDTO> getPeriodos(){
        var periodos = periodoService.getPeriodos();

        return periodoControllerMapper.convertToPeriodoDTOList(periodos);
    }

    @GetMapping("/{idPeriodo}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public PeriodoResponseDTO getPeriodo(@PathVariable Integer idPeriodo){
        Periodo periodo = periodoService.getPeriodo(idPeriodo);

        return periodoControllerMapper.convertToPeriodoDTO(periodo);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.CREATED)
    public PeriodoResponseDTO addPeriodo(@RequestBody PeriodoRequestDTO periodoRequestDTO){
        Periodo periodo = periodoControllerMapper.convertToPeriodo(periodoRequestDTO);

        Periodo periodoSalvo = periodoService.addPeriodo(periodo);

        return periodoControllerMapper.convertToPeriodoDTO(periodoSalvo);
    }

    @PutMapping("/{idPeriodo}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public PeriodoResponseDTO updatePeriodo(@RequestBody PeriodoRequestDTO periodoRequestDTO, @PathVariable Integer idPeriodo){
        Periodo periodo = periodoControllerMapper.convertToPeriodo(periodoRequestDTO, idPeriodo);

        Periodo periodoAtualizado = periodoService.updatePeriodo(periodo);

        return periodoControllerMapper.convertToPeriodoDTO(periodoAtualizado);
    }

    @DeleteMapping("/{idPeriodo}")
    @PreAuthorize("hasAnyRole('ROLE_DIRETOR')")
    @ResponseStatus(HttpStatus.OK)
    public void deletePeriodo(@PathVariable Integer idPeriodo){
        periodoService.deletePeriodo(idPeriodo);
    }
}