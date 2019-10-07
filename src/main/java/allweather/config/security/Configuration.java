package allweather.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class Configuration extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenAuthenticationManager tokenAuthenticationManager;

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
                .antMatchers("/registration/**", "/login/**");
    }


    private TokenAuthenticationFilter getTokenAuthenticationFilter(){
        return new TokenAuthenticationFilter("/**", tokenAuthenticationManager);
    }

}
