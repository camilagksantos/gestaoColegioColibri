package pt.colegio.colibri.business.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pt.colegio.colibri.model.repository.LoginRepository;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl  implements UserDetailsService {

    private final LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username ) throws UsernameNotFoundException {
        return loginRepository.findByUsername( username )
                               .orElseThrow(() -> new UsernameNotFoundException( "User Not Found with username:"+username ));
    }
}
