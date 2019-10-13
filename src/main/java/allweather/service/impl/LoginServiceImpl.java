package allweather.service.impl;

import allweather.api.LoginDto;
import allweather.entity.user.User;
import allweather.repository.UserRepository;
import allweather.service.LoginService;
import allweather.utils.TokenUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class LoginServiceImpl implements LoginService {
    
    private final TokenUtil tokenUtil;
    
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public LoginServiceImpl(TokenUtil tokenUtil, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.tokenUtil = tokenUtil;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public String login(LoginDto loginDto) {
        
        User user = userRepository.findByLogin(loginDto.getLogin()).orElseThrow(NoSuchElementException::new);
        if (passwordEncoder.matches(loginDto.getPassword(), user.getPassword())){
            return tokenUtil.generateToken(loginDto.getLogin());
        } else return "auth failed";
    }
}
