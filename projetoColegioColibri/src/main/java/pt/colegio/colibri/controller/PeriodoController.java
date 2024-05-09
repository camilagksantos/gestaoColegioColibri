package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pt.colegio.colibri.business.core.Periodo;
import pt.colegio.colibri.business.service.PeriodoService;
import pt.colegio.colibri.controller.dtos.request.PeriodoRequestDTO;
import pt.colegio.colibri.controller.dtos.response.PeriodoResponseDTO;
import pt.colegio.colibri.controller.mapper.PeriodoControllerMapper;

import java.util.List;

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
    @ResponseStatus(HttpStatus.OK)
    public List<PeriodoResponseDTO> getPeriodos(){
        var periodos = periodoService.getPeriodos();

        return periodoControllerMapper.convertToPeriodoDTOList(periodos);
    }

    @GetMapping("/{idPeriodo}")
    @ResponseStatus(HttpStatus.OK)
    public PeriodoResponseDTO getPeriodo(@PathVariable Integer idPeriodo){
        Periodo periodo = periodoService.getPeriodo(idPeriodo);

        return periodoControllerMapper.convertToPeriodoDTO(periodo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PeriodoResponseDTO addPeriodo(@RequestBody PeriodoRequestDTO periodoRequestDTO){
        Periodo periodo = periodoControllerMapper.convertToPeriodo(periodoRequestDTO);

        Periodo periodoSalvo = periodoService.addPeriodo(periodo);

        return periodoControllerMapper.convertToPeriodoDTO(periodoSalvo);
    }

    @PutMapping("/{idPeriodo}")
    @ResponseStatus(HttpStatus.OK)
    public PeriodoResponseDTO updatePeriodo(@RequestBody PeriodoRequestDTO periodoRequestDTO, @PathVariable Integer idPeriodo){
        Periodo periodo = periodoControllerMapper.convertToPeriodo(periodoRequestDTO, idPeriodo);

        Periodo periodoAtualizado = periodoService.updatePeriodo(periodo);

        return periodoControllerMapper.convertToPeriodoDTO(periodoAtualizado);
    }

    @DeleteMapping("/{idPeriodo}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePeriodo(@PathVariable Integer idPeriodo){
        periodoService.deletePeriodo(idPeriodo);
    }
}
