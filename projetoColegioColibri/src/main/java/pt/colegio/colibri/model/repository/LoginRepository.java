package pt.colegio.colibri.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.colegio.colibri.model.entity.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {

}
