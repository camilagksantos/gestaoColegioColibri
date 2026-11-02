package pt.colegio.colibri.business.service;

import org.springframework.stereotype.Service;
import pt.colegio.colibri.business.core.Funcionario;
import pt.colegio.colibri.model.FuncionarioModel;

import java.util.List;

//Este código é parte de uma aplicação Spring Boot, especificamente uma classe de serviço (FuncionarioService) que interage
// com um modelo de dados (Funcionario) para realizar operações CRUD (Create, Read, Update, Delete) relacionadas a
// funcionarios de uma escola.

//A classe é anotada com @Service, marcando-a como um componente de serviço no Spring. Isso significa que o Spring
// pode gerenciar instâncias desta classe automaticamente.

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
