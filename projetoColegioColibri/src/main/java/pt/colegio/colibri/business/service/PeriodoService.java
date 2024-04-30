package pt.colegio.colibri.business.service;

import org.springframework.stereotype.Service;
import pt.colegio.colibri.business.core.Periodo;
import pt.colegio.colibri.model.PeriodoModel;

import java.util.List;

@Service
public class PeriodoService {

    private final PeriodoModel periodoModel;

    public PeriodoService(PeriodoModel periodoModel) {
        this.periodoModel = periodoModel;
    }

    public List<Periodo> getPeriodos(){
        return periodoModel.getPeriodo();
    }
}
