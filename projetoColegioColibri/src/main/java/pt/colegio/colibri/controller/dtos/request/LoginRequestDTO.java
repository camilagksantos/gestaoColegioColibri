package pt.colegio.colibri.controller.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import pt.colegio.colibri.business.core.enuns.Roles;

@Data
public class LoginRequestDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotNull
    private Roles role;
}
