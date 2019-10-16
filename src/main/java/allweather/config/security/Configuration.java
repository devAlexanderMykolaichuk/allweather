package allweather.config.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class Configuration extends WebSecurityConfigurerAdapter {

    private final TokenAuthenticationManager tokenAuthenticationManager;

    public Configuration(TokenAuthenticationManager tokenAuthenticationManager) {
        this.tokenAuthenticationManager = tokenAuthenticationManager;
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .addFilterBefore(getTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests().anyRequest().authenticated();
    }

    @Override
    public void configure(WebSecurity webSecurity){
        webSecurity
                .ignoring()
                .antMatchers("/registration/**", "/login/**", "/test/**");
    }


    private TokenAuthenticationFilter getTokenAuthenticationFilter(){
        return new TokenAuthenticationFilter("/api/**", tokenAuthenticationManager);
    }

}
