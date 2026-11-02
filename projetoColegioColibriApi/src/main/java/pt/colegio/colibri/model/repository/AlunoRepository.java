package pt.colegio.colibri.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.colegio.colibri.model.entity.AlunoEntity;

import java.util.List;

//Em resumo, este código define uma interface AlunoRepository que estende JpaRepository para a entidade AlunoEntity.
// Isso permite que você realize operações CRUD na entidade Aluno através deste repositório, sem precisar escrever a
// lógica de acesso ao banco de dados manualmente. O Spring Data JPA cuidará de tudo isso, permitindo ganho de tempo e
// priorização de outros pontos.

public interface AlunoRepository extends JpaRepository<AlunoEntity, Integer> {
    @Query("select a from AlunoEntity a where a.turma.idTurma = ?1")
    List<AlunoEntity> findByTurma_IdTurma(Integer idTurma);

    @Query("select a from AlunoEntity a where a.login.idLogin = ?1")
    AlunoEntity findByLogin_IdLogin(Integer idLogin);

}
