package pt.colegio.colibri.model;

import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Periodo;
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

    public List<Periodo> getPeriodo(){
        var periodoEntity = periodoRepository.findAll();

        return periodoModelMapper.convertToPeriodoList(periodoEntity);
    }
}
