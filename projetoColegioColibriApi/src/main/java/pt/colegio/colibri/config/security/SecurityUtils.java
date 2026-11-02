package pt.colegio.colibri.config.security;

import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class SecurityUtils {

    private static Collection<? extends GrantedAuthority> getCurrentUserRoles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            // Nenhum utilizador autenticado
            return null;
        }
        return authentication.getAuthorities();
    }

    public static String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return userDetails.getUsername(); // Isso retorna o nome de usuário
        }
        return null; // Retorna null ou algum valor padrão caso não esteja autenticado
    }

    public static String getRole() {
        Collection<? extends GrantedAuthority> roles = getCurrentUserRoles();
        if (roles != null) {
            for (GrantedAuthority role : roles) {
                return role.getAuthority().toString().toUpperCase();
            }
        }
        return null;
    }
}
