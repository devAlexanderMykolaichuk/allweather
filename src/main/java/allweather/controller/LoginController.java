package allweather.controller;

import allweather.api.LoginDto;
import allweather.service.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin.liveconnect.SecurityContextHelper;

@RestController
@RequestMapping("/login")
@Log4j2
public class LoginController {
    
    @Autowired
    private LoginService loginService;
    
    @PostMapping
    public String login(@RequestBody LoginDto loginDto){
        log.info(SecurityContextHolder.getContext().getAuthentication());
        return loginService.login(loginDto);
    }
}
