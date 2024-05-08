package pt.colegio.colibri.model;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import pt.colegio.colibri.business.core.Funcionario;
import pt.colegio.colibri.model.entity.FuncionarioEntity;
import pt.colegio.colibri.model.entity.LoginEntity;
import pt.colegio.colibri.model.mapper.FuncionarioModelMapper;
import pt.colegio.colibri.model.repository.FuncionarioRepository;
import pt.colegio.colibri.model.repository.LoginRepository;

import java.util.List;

@Component
public class FuncionarioModel {
    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioModelMapper funcionarioModelMapper;
    private final LoginRepository loginRepository;

    public FuncionarioModel(FuncionarioRepository funcionarioRepository, FuncionarioModelMapper funcionarioModelMapper, LoginRepository loginRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioModelMapper = funcionarioModelMapper;
        this.loginRepository = loginRepository;
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

    @Transactional
    public Funcionario addFuncionario(Funcionario funcionario) {
        var login = getLogin( funcionario.getLogin().getIdLogin());

        FuncionarioEntity funcionarioEntity = funcionarioModelMapper.convertToFuncionarioEntity(funcionario, login);

        funcionarioRepository.save(funcionarioEntity);

        return funcionarioModelMapper.convertToFuncionario(funcionarioEntity);
    }

    @Transactional
    public Funcionario updateFuncionario(Funcionario funcionario) {
        var login = getLogin( funcionario.getLogin().getIdLogin());

        FuncionarioEntity funcionarioEntity = funcionarioModelMapper.convertToFuncionarioEntity(funcionario, login);

        funcionarioRepository.save(funcionarioEntity);

        return funcionarioModelMapper.convertToFuncionario(funcionarioEntity);
    }

    public void deleteFuncionario(Integer idFuncionario) {
        funcionarioRepository.deleteById(idFuncionario);
    }

    private LoginEntity getLogin(Integer loginId){
        return loginRepository.findById(loginId)
                              .orElseThrow(() -> new RuntimeException("Login não Encontrado!"));
    }
}
