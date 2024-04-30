package pt.colegio.colibri.business.service;

import org.springframework.stereotype.Service;
import pt.colegio.colibri.business.core.Funcionario;
import pt.colegio.colibri.model.FuncionarioModel;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioModel funcinarioModel;

    public FuncionarioService(FuncionarioModel funcinarioModel) {
        this.funcinarioModel = funcinarioModel;
    }

    public List<Funcionario> getFuncionarios(){
        return funcinarioModel.getFuncionarios();
    }
}
