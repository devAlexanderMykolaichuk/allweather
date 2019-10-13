package allweather.service.impl;

import allweather.api.user.CreateUserRequest;
import allweather.entity.user.Role;
import allweather.entity.user.User;
import allweather.repository.UserRepository;
import allweather.service.RegistrationService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public RegistrationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public String registerNewUser(CreateUserRequest userDto) {
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoleList(Collections.singletonList(Role.USER));
        userRepository.save(user);
        return "Ok";
    }
}
