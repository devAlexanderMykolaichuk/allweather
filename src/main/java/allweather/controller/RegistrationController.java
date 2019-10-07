package allweather.controller;

import allweather.api.user.CreateUserRequest;
import allweather.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    
    @Autowired
    private RegistrationService registrationService;
    
    @PostMapping("/user")
    public String registerUser(@RequestBody CreateUserRequest userDto){
        return registrationService.registerNewUser(userDto);
    }
}
