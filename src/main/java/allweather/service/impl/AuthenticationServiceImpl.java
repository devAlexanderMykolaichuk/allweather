package allweather.service.impl;

import allweather.entity.user.User;
import allweather.repository.UserRepository;
import allweather.service.AuthenticationService;
import allweather.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Authentication authenticateByToken(String token) {
        String login = tokenUtil.getUsernameFromToken(token);
        Optional<User> optUser = userRepository.findByLogin(login);
        try {
            User user = optUser.orElseThrow(NullPointerException::new);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}
