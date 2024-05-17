package pt.colegio.colibri.business.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pt.colegio.colibri.model.LoginModel;
import pt.colegio.colibri.model.repository.LoginRepository;

//Esta classe é parte de uma aplicação Spring Boot que utiliza o Spring Security para autenticação e autorização.
//este código é responsável por carregar os detalhes do usuário a partir do banco de dados quando um nome de usuário
// é fornecido. Isso é crucial para o processo de autenticação, pois permite ao Spring Security verificar se um
// usuário existe antes de permitir o acesso a recursos protegidos.

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl  implements UserDetailsService {

    private final LoginModel loginModel;

    @Override
    public UserDetails loadUserByUsername(String username ) throws UsernameNotFoundException {
        return loginModel.loadUserByUsername(username);
    }
}
