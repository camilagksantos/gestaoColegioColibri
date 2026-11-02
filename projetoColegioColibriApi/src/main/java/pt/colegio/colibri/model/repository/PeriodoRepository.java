package pt.colegio.colibri.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.colegio.colibri.model.entity.PeriodoEntity;

//Em resumo, este código define uma interface PeriodoRepository que estende JpaRepository para a entidade PeriodoEntity.
// Isso permite que você realize operações CRUD na entidade Aluno através deste repositório, sem precisar escrever a
// lógica de acesso ao banco de dados manualmente. O Spring Data JPA cuidará de tudo isso, permitindo ganho de tempo e
// priorização de outros pontos.

public interface PeriodoRepository extends JpaRepository<PeriodoEntity, Integer> {

}
