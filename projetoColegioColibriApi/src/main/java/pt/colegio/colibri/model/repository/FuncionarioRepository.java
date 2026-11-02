package pt.colegio.colibri.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pt.colegio.colibri.model.entity.FuncionarioEntity;

//Em resumo, este código define uma interface FuncionarioRepository que estende JpaRepository para a entidade
// FuncionarioEntity. Isso permite que você realize operações CRUD na entidade Aluno através deste repositório, sem
// precisar escrever a lógica de acesso ao banco de dados manualmente. O Spring Data JPA cuidará de tudo isso,
// permitindo ganho de tempo e priorização de outros pontos.

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Integer> {
    @Query("select f from FuncionarioEntity f where f.login.idLogin = ?1")
    FuncionarioEntity findByLogin_IdLogin(Integer idLogin);

}
