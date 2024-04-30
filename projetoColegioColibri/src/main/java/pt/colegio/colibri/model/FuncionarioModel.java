package pt.colegio.colibri.model;

import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Funcionario;
import pt.colegio.colibri.model.mapper.FuncionarioModelMapper;
import pt.colegio.colibri.model.repository.FuncionarioRepository;

import java.util.List;

@Component
public class FuncionarioModel {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioModelMapper funcionarioModelMapper;

    public FuncionarioModel(FuncionarioRepository funcionarioRepository, FuncionarioModelMapper funcionarioModelMapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioModelMapper = funcionarioModelMapper;
    }

    public List<Funcionario> getFuncionarios() {
        var funcioanriosEntity = funcionarioRepository.findAll();

        return funcionarioModelMapper.convertToFuncionarioList(funcioanriosEntity);
    }
}
