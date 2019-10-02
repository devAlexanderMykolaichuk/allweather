package allweather.config.security;


import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Log4j2
public class TokenAuthentication extends AbstractAuthenticationToken {

    private String token;
    private PrincipalUser principalUser;


    public TokenAuthentication(String token) {
        super(null);
        this.token = token;
    }

    public TokenAuthentication(Collection<? extends GrantedAuthority> authorities, PrincipalUser principalUser) {
        super(authorities);
        this.principalUser = principalUser;
        super.setAuthenticated(true);
    }

    public String getToken(){
        return token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return principalUser;
    }

    @Override
    public void setAuthenticated(boolean authenticated){
        if (authenticated){
            log.info("Only constructor");
            super.setAuthenticated(false);
        }
    }
}
