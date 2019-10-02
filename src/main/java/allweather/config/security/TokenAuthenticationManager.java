package allweather.config.security;

import allweather.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class TokenAuthenticationManager implements AuthenticationManager {

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        TokenAuthentication tokenAuthentication = (TokenAuthentication) authentication;
        return authenticationService.authenticateByToken(tokenAuthentication.getToken());
    }
}
