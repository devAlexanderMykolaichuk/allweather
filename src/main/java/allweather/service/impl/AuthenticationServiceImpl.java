package allweather.service.impl;

import allweather.config.security.PrincipalUser;
import allweather.config.security.TokenAuthentication;
import allweather.entity.user.User;
import allweather.repository.UserRepository;
import allweather.service.AuthenticationService;
import allweather.utils.TokenUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final TokenUtil tokenUtil;

    private final UserRepository userRepository;

    public AuthenticationServiceImpl(TokenUtil tokenUtil, UserRepository userRepository) {
        this.tokenUtil = tokenUtil;
        this.userRepository = userRepository;
    }


    @Override
    public Authentication authenticateByToken(String token) {
        String login = tokenUtil.getUsernameFromToken(token);
        Optional<User> optUser = userRepository.findByLogin(login);
        User user = optUser.orElseThrow(() -> new NoSuchElementException("User not found"));

        return new TokenAuthentication(getUserRoles(user), genPrincipalUser(user));
    }

    private Collection<? extends GrantedAuthority> getUserRoles(User user){
        return user.getRoleList().stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
    }

    private PrincipalUser genPrincipalUser(User user){
        return PrincipalUser.builder()
                .login(user.getLogin())
                .email(user.getEmail())
                .build();
    }
}
