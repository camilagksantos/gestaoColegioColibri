package pt.colegio.colibri.model;

import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Nota;
import pt.colegio.colibri.model.mapper.NotaModelMapper;
import pt.colegio.colibri.model.repository.NotaRepository;

import java.util.List;

@Component
public class NotaModel {

    private final NotaRepository notaRepository;
    private final NotaModelMapper notaModelMapper;

    public NotaModel(NotaRepository notaRepository, NotaModelMapper notaModelMapper) {
        this.notaRepository = notaRepository;
        this.notaModelMapper = notaModelMapper;
    }

    public List<Nota> getNotas() {
        var notasEntity = notaRepository.findAll();

        return notaModelMapper.convertToNotaList(notasEntity);
    }
}
