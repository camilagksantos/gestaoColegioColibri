package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pt.colegio.colibri.business.service.PeriodoService;
import pt.colegio.colibri.controller.dtos.PeriodoDTO;
import pt.colegio.colibri.controller.mapper.PeriodoControllerMapper;

import java.util.List;

@RestController
@RequestMapping("/periodo")
public class PeriodoController {

    private final PeriodoService periodoService;
    private final PeriodoControllerMapper periodoControllerMapper;

    public PeriodoController(PeriodoService periodoService, PeriodoControllerMapper periodoControllerMapper) {
        this.periodoService = periodoService;
        this.periodoControllerMapper = periodoControllerMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PeriodoDTO> getPeriodos(){
        var periodos = periodoService.getPeriodos();
        return periodoControllerMapper.convertToPeriodoDTOList(periodos);
    }
}
