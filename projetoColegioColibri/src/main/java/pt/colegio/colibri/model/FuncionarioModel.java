package pt.colegio.colibri.model;

import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Funcionario;
import pt.colegio.colibri.model.entity.FuncionarioEntity;
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

    public Funcionario getFuncionario(Integer idFuncionario) {
        FuncionarioEntity funcionarioEntity = funcionarioRepository.findById(idFuncionario)
                .orElseThrow(() -> new RuntimeException("Registo não Encontrado!"));
        return funcionarioModelMapper.convertToFuncionario(funcionarioEntity);
    }

    public Funcionario addFuncionario(Funcionario funcionario) {
        FuncionarioEntity funcionarioEntity = funcionarioModelMapper.convertToFuncionarioEntity(funcionario);

        funcionarioRepository.save(funcionarioEntity);

        return funcionarioModelMapper.convertToFuncionario(funcionarioEntity);
    }

    public Funcionario updateFuncionario(Funcionario funcionario) {
        FuncionarioEntity funcionarioEntity = funcionarioModelMapper.convertToFuncionarioEntity(funcionario);

        funcionarioRepository.save(funcionarioEntity);

        return funcionarioModelMapper.convertToFuncionario(funcionarioEntity);
    }

    public void deleteFuncionario(Integer idFuncionario) {
        funcionarioRepository.deleteById(idFuncionario);
    }
}
