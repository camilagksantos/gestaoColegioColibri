package pt.colegio.colibri.model;

import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Nota;
import pt.colegio.colibri.model.entity.NotaEntity;
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

    public Nota getNota(Integer idNota) {
        NotaEntity notaEntity = notaRepository.findById(idNota)
                .orElseThrow(() -> new RuntimeException("Registo não Encontrado!"));
        return notaModelMapper.convertToNota(notaEntity);
    }

    public Nota addNota(Nota nota) {
        NotaEntity notaEntity = notaModelMapper.convertToNotaEntity(nota);

        notaRepository.save(notaEntity);

        return notaModelMapper.convertToNota(notaEntity);
    }

    public Nota updateNota(Nota nota) {
        NotaEntity notaEntity = notaModelMapper.convertToNotaEntity(nota);

        notaRepository.save(notaEntity);

        return notaModelMapper.convertToNota(notaEntity);
    }

    public void deleteNota(Integer idNota) {
        notaRepository.deleteById(idNota);
    }
}
