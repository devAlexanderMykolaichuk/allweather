package allweather.service.impl;

import allweather.entity.user.User;
import allweather.repository.UserRepository;
import allweather.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User registerNewUser(User user) {
        return userRepository.save(user);
    }
}
