package allweather.controller;

import allweather.api.LoginDto;
import allweather.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    private LoginService loginService;
    
    @PostMapping
    public String login(@RequestBody LoginDto loginDto){
        return loginService.login(loginDto);
    }
}
