package pt.colegio.colibri.business.service;

import org.springframework.stereotype.Service;
import pt.colegio.colibri.business.core.Nota;
import pt.colegio.colibri.model.NotaModel;

import java.util.List;

@Service
public class NotaService {

    private final NotaModel notaModel;

    public NotaService(NotaModel notaModel) {
        this.notaModel = notaModel;
    }

    public List<Nota> getNotas(){
        return notaModel.getNotas();
    }

    public Nota getNota(Integer idNota) {
        return notaModel.getNota(idNota);
    }

    public Nota addNota(Nota nota) {
        return notaModel.addNota(nota);
    }

    public Nota updateNota(Nota nota) {
        return notaModel.updateNota(nota);
    }

    public void deleteNota(Integer idNota) {
        notaModel.deleteNota(idNota);
    }
}
