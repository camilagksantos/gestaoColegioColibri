package pt.colegio.colibri.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.colegio.colibri.model.entity.TurmaEntity;

//Em resumo, este código define uma interface TurmaRepository que estende JpaRepository para a entidade TurmaEntity.
// Isso permite que você realize operações CRUD na entidade Aluno através deste repositório, sem precisar escrever a
// lógica de acesso ao banco de dados manualmente. O Spring Data JPA cuidará de tudo isso, permitindo ganho de tempo e
// priorização de outros pontos.

public interface TurmaRepository extends JpaRepository<TurmaEntity, Integer> {
    @Query("select t from TurmaEntity t where t.professor.idFuncionario = ?1")
    TurmaEntity findByProfessor_IdFuncionario(Integer idFuncionario);

}
