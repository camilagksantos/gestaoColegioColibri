package pt.colegio.colibri.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.colegio.colibri.model.entity.FuncionarioEntity;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Integer> {

}
