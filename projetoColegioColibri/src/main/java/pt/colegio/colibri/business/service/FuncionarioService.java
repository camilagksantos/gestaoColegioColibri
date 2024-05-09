package pt.colegio.colibri.business.service;

import org.springframework.stereotype.Service;
import pt.colegio.colibri.business.core.Funcionario;
import pt.colegio.colibri.model.FuncionarioModel;

import java.util.List;

@Service
public class FuncionarioService {
    private final FuncionarioModel funcionarioModel;

    public FuncionarioService(FuncionarioModel funcionarioModel) {
        this.funcionarioModel = funcionarioModel;
    }

    public List<Funcionario> getFuncionarios(){
        return funcionarioModel.getFuncionarios();
    }

    public Funcionario getFuncionario(Integer idFuncionario) {
        return funcionarioModel.getFuncionario(idFuncionario);
    }

    public Funcionario addFuncionario(Funcionario funcionario) {
        return funcionarioModel.addFuncionario(funcionario);
    }

    public Funcionario updateFuncionario(Funcionario funcionario) {
        return funcionarioModel.updateFuncionario(funcionario);
    }

    public void deleteFuncionario(Integer idFuncionario) {
        funcionarioModel.deleteFuncionario(idFuncionario);
    }
}
