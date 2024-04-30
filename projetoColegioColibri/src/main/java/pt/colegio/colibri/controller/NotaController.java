package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pt.colegio.colibri.business.service.NotaService;
import pt.colegio.colibri.controller.dtos.NotaDTO;
import pt.colegio.colibri.controller.mapper.NotaControllerMapper;

import java.util.List;

@RestController
@RequestMapping("/nota")
public class NotaController {

    private final NotaService notaService;
    private final NotaControllerMapper notaControllerMapper;

    public NotaController(NotaService notaService, NotaControllerMapper notaControllerMapper) {
        this.notaService = notaService;
        this.notaControllerMapper = notaControllerMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<NotaDTO> getNotas(){
        var notas = notaService.getNotas();
        return notaControllerMapper.convertToNotaDTOList(notas);
    }
}
