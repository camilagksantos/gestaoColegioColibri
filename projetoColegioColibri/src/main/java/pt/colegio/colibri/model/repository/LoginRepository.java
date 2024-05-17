package pt.colegio.colibri.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.colegio.colibri.model.entity.LoginEntity;

import java.util.Optional;

//Em resumo, este código define uma interface LoginRepository que estende JpaRepository para a entidade LoginEntity.
// Isso permite que você realize operações CRUD na entidade Aluno através deste repositório, sem precisar escrever a
// lógica de acesso ao banco de dados manualmente. O Spring Data JPA cuidará de tudo isso, permitindo ganho de tempo e
// priorização de outros pontos.

public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {

    Optional<LoginEntity> findByUsername(String username);


}
