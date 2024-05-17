package pt.colegio.colibri.business.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pt.colegio.colibri.business.core.Aluno;
import pt.colegio.colibri.config.security.SecurityUtils;
import pt.colegio.colibri.model.AlunoModel;
import pt.colegio.colibri.model.FuncionarioModel;
import pt.colegio.colibri.model.LoginModel;
import pt.colegio.colibri.model.TurmaModel;

import java.util.List;

//Este código é parte de uma aplicação Spring Boot, especificamente uma classe de serviço (AlunoService) que interage
// com um modelo de dados (Aluno) para realizar operações CRUD (Create, Read, Update, Delete) relacionadas a
// Alunos de uma escola.

//A classe é anotada com @Service, marcando-a como um componente de serviço no Spring. Isso significa que o Spring
// pode gerenciar instâncias desta classe automaticamente.

@Service
@AllArgsConstructor
public class AlunoService {
    private final AlunoModel alunoModel;
    private final LoginModel loginModel;
    private final TurmaModel turmaModel;
    private final FuncionarioModel funcionarioModel;

    public List<Aluno> getAlunos(){

        var role = SecurityUtils.getRole();

        if (role.equals("ROLE_PROFESSOR")) {

            var username = SecurityUtils.getUsername();

            var login = loginModel.getLoginByUsername(username);

            var funcionario = funcionarioModel.getFuncionarioByLoginId(login.getIdLogin());

            var turma = turmaModel.getTurmaByFuncionarioId(funcionario.getId());

            return alunoModel.getAlunosByTurmaId(turma.getIdTurma());

        } else if (role.equals("ROLE_ALUNO")) {
            var username = SecurityUtils.getUsername();

            var login = loginModel.getLoginByUsername(username);

            var aluno = alunoModel.getAlunoByLoginId(login.getIdLogin());

            return alunoModel.getAlunosByTurmaId(aluno.getTurma().getIdTurma());
        }

        return alunoModel.getAlunos();
    }

    public Aluno getAluno(Integer idAluno) {
        return alunoModel.getAluno(idAluno);
    }

    public Aluno addAluno(Aluno aluno) {
        return alunoModel.addAluno(aluno);
    }

    public Aluno updateAluno(Aluno aluno) {
        return alunoModel.updateAluno(aluno);
    }

    public void deleteAluno(Integer idAluno) {
        alunoModel.deleteAluno(idAluno);
    }
}
