package pt.colegio.colibri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pt.colegio.colibri.business.core.Nota;
import pt.colegio.colibri.business.service.NotaService;
import pt.colegio.colibri.controller.dtos.request.NotaRequestDTO;
import pt.colegio.colibri.controller.dtos.response.NotaResponseDTO;
import pt.colegio.colibri.controller.mapper.NotaControllerMapper;

import java.util.List;

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
    @ResponseStatus(HttpStatus.OK)
    public List<NotaResponseDTO> getNotas(){
        var notas = notaService.getNotas();

        return notaControllerMapper.convertToNotaDTOList(notas);
    }

    @GetMapping("/{idNota}")
    @ResponseStatus(HttpStatus.OK)
    public NotaResponseDTO getNota(@PathVariable Integer idNota){
        Nota nota = notaService.getNota(idNota);

        return notaControllerMapper.convertToNotaDTO(nota);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NotaResponseDTO addNota(@RequestBody NotaRequestDTO notaRequestDTO){
        Nota nota = notaControllerMapper.convertToNota(notaRequestDTO);

        Nota notaSalvo = notaService.addNota(nota);

        return notaControllerMapper.convertToNotaDTO(notaSalvo);
    }

    @PutMapping("/{idNota}")
    @ResponseStatus(HttpStatus.OK)
    public NotaResponseDTO updateNota(@RequestBody NotaRequestDTO notaRequestDTO, @PathVariable Integer idNota){
        Nota nota = notaControllerMapper.convertToNota(notaRequestDTO, idNota);

        Nota notaAtualizado = notaService.updateNota(nota);

        return notaControllerMapper.convertToNotaDTO(notaAtualizado);
    }

    @DeleteMapping("/{idNota}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteNota(@PathVariable Integer idNota){
        notaService.deleteNota(idNota);
    }
}
