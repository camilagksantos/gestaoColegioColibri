package pt.colegio.colibri.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.colegio.colibri.model.entity.AlunoEntity;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Integer> {

}
