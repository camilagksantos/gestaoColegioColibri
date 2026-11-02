package pt.colegio.colibri.business.service;

import org.springframework.stereotype.Service;
import pt.colegio.colibri.business.core.Periodo;
import pt.colegio.colibri.model.PeriodoModel;

import java.util.List;

//Este código é parte de uma aplicação Spring Boot, especificamente uma classe de serviço (PeriodoService) que interage
// com um modelo de dados (Periodo) para realizar operações CRUD (Create, Read, Update, Delete) relacionadas as
// periodos do ano de cada nota.

//A classe é anotada com @Service, marcando-a como um componente de serviço no Spring. Isso significa que o Spring
// pode gerenciar instâncias desta classe automaticamente.

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
