package allweather.config.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
public class TokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {


    protected TokenAuthenticationFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
        super(defaultFilterProcessesUrl);
        setAuthenticationManager(authenticationManager);
        setAuthenticationSuccessHandler( (request, response, authentication) -> {
            log.info("AuthenticationSuccessHandler in work");
            request.getRequestDispatcher(request.getServletPath()).forward(request, response);
        });
        setAuthenticationFailureHandler((request, response, authenticationException) -> {
            log.info("AuthenticationSuccessHandler in work");
            response.getOutputStream().print(authenticationException.getMessage());
        });
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException {
        String token = httpServletRequest.getHeader("token");
        TokenAuthentication tokenAuthentication = new TokenAuthentication(token);
        return getAuthenticationManager().authenticate(tokenAuthentication);
    }
}
