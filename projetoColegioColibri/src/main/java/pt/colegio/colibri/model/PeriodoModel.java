package pt.colegio.colibri.model;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Periodo;
import pt.colegio.colibri.model.entity.PeriodoEntity;
import pt.colegio.colibri.model.mapper.PeriodoModelMapper;
import pt.colegio.colibri.model.repository.PeriodoRepository;

import java.util.List;

@Component
public class PeriodoModel {
    private final PeriodoRepository periodoRepository;
    private final PeriodoModelMapper periodoModelMapper;

    public PeriodoModel(PeriodoRepository periodoRepository, PeriodoModelMapper periodoModelMapper) {
        this.periodoRepository = periodoRepository;
        this.periodoModelMapper = periodoModelMapper;
    }

    public List<Periodo> getPeriodos(){
        var periodoEntity = periodoRepository.findAll();

        return periodoModelMapper.convertToPeriodoList(periodoEntity);
    }

    public Periodo getPeriodo(Integer idPeriodo) {
        PeriodoEntity periodoEntity = periodoRepository.findById(idPeriodo)
                                                       .orElseThrow(() -> new RuntimeException("Registo não Encontrado!"));

        return periodoModelMapper.convertToPeriodo(periodoEntity);
    }

    @Transactional
    public Periodo addPeriodo(Periodo periodo) {
        PeriodoEntity periodoEntity = periodoModelMapper.convertToPeriodoEntity(periodo);

        periodoRepository.save(periodoEntity);

        return periodoModelMapper.convertToPeriodo(periodoEntity);
    }

    @Transactional
    public Periodo updatePeriodo(Periodo periodo) {
        PeriodoEntity periodoEntity = periodoModelMapper.convertToPeriodoEntity(periodo);

        periodoRepository.save(periodoEntity);

        return periodoModelMapper.convertToPeriodo(periodoEntity);
    }

    public void deletePeriodo(Integer idPeriodo) {
        periodoRepository.deleteById(idPeriodo);
    }
}
