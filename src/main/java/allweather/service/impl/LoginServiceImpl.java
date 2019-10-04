package allweather.service.impl;

import allweather.api.LoginDto;
import allweather.entity.user.User;
import allweather.repository.UserRepository;
import allweather.service.LoginService;
import allweather.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class LoginServiceImpl implements LoginService {
    
    @Autowired
    private TokenUtil tokenUtil;
    
    @Autowired
    private UserRepository userRepository;
    
    
    @Override
    public String login(LoginDto loginDto) {
        
        User user = userRepository.findByLogin(loginDto.getLogin()).orElseThrow(NoSuchElementException::new);
        
        if (user.getPassword().equals(loginDto.getPassword())){
            return tokenUtil.generateToken(loginDto.getLogin());
        } else return "auth failed";
    }
}
