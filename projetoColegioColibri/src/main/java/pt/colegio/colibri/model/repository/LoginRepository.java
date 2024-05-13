package pt.colegio.colibri.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.colegio.colibri.model.entity.LoginEntity;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {
    Optional<LoginEntity> findByUsername(String username);


}
