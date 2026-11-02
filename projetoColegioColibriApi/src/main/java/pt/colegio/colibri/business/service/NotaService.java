package pt.colegio.colibri.business.service;

import org.springframework.stereotype.Service;
import pt.colegio.colibri.business.core.Aluno;
import pt.colegio.colibri.business.core.Nota;
import pt.colegio.colibri.config.security.SecurityUtils;
import pt.colegio.colibri.model.*;

import java.util.ArrayList;
import java.util.List;

//Este código é parte de uma aplicação Spring Boot, especificamente uma classe de serviço (NotaService) que interage
// com um modelo de dados (Nota) para realizar operações CRUD (Create, Read, Update, Delete) relacionadas a
// notas dos alunos de uma escola.

//A classe é anotada com @Service, marcando-a como um componente de serviço no Spring. Isso significa que o Spring
// pode gerenciar instâncias desta classe automaticamente.

@Service
public class NotaService {
    private final NotaModel notaModel;
    private final LoginModel loginModel;
    private final FuncionarioModel funcionarioModel;
    private final TurmaModel turmaModel;
    private final AlunoModel alunoModel;

    public NotaService(NotaModel notaModel, LoginModel loginModel, FuncionarioModel funcionarioModel, TurmaModel turmaModel, AlunoModel alunoModel) {
        this.notaModel = notaModel;
        this.loginModel = loginModel;
        this.funcionarioModel = funcionarioModel;
        this.turmaModel = turmaModel;
        this.alunoModel = alunoModel;
    }

    public List<Nota> getNotas(){
        var role = SecurityUtils.getRole();

        if (role.equals("ROLE_PROFESSOR")){
            var username = SecurityUtils.getUsername();

            var login = loginModel.getLoginByUsername(username);

            var funcionario = funcionarioModel.getFuncionarioByLoginId(login.getIdLogin());

            var turma = turmaModel.getTurmaByFuncionarioId(funcionario.getId());

            var alunos = alunoModel.getAlunosByTurmaId(turma.getIdTurma());

            List<Nota> notasDosAlunos = new ArrayList<>();
            for (Aluno aluno : alunos) {
                notasDosAlunos.addAll(notaModel.getNotasByAlunoId(aluno.getId()));
            }
            return notasDosAlunos;
        } else if (role.equals("ROLE_ALUNO")) {
            var username = SecurityUtils.getUsername();

            var login = loginModel.getLoginByUsername(username);

            var aluno = alunoModel.getAlunoByLoginId(login.getIdLogin());

            return notaModel.getNotasByAlunoId(aluno.getId());
        }

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
