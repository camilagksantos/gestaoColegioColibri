package pt.colegio.colibri.model.mapper;

import org.mapstruct.Mapper;
import pt.colegio.colibri.business.core.Login;
import pt.colegio.colibri.model.entity.LoginEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoginModelMapper {

    LoginEntity convertToLoginEntity(Login login);

    Login convertToLogin(LoginEntity loginEntity);

    List<Login> convertToLoginList(List<LoginEntity> loginEntities);
}
