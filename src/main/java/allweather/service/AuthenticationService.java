package allweather.service;

import org.springframework.security.core.Authentication;

public interface AuthenticationService {

    Authentication authenticateByToken(String token);
}
