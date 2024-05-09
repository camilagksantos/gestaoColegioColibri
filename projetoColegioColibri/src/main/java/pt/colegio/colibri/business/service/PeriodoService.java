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
        return periodoModel.getPeriodos();
    }

    public Periodo getPeriodo(Integer idPeriodo) {
        return periodoModel.getPeriodo(idPeriodo);
    }

    public Periodo addPeriodo(Periodo periodo) {
        return periodoModel.addPeriodo(periodo);
    }

    public Periodo updatePeriodo(Periodo periodo) {
        return periodoModel.updatePeriodo(periodo);
    }

    public void deletePeriodo(Integer idPeriodo) {
        periodoModel.deletePeriodo(idPeriodo);
    }
}
