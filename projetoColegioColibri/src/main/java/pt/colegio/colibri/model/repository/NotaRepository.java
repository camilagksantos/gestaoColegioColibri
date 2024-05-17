package pt.colegio.colibri.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.colegio.colibri.model.entity.NotaEntity;

import java.util.List;

//Em resumo, este código define uma interface NotaRepository que estende JpaRepository para a entidade NotaEntity.
// Isso permite que você realize operações CRUD na entidade Aluno através deste repositório, sem precisar escrever a
// lógica de acesso ao banco de dados manualmente. O Spring Data JPA cuidará de tudo isso, permitindo ganho de tempo e
// priorização de outros pontos.

public interface NotaRepository extends JpaRepository<NotaEntity, Integer> {
    @Query("select n from NotaEntity n where n.aluno.idAluno = ?1")
    List<NotaEntity> findByAluno_IdAluno(Integer idAluno);

}
