package allweather.service;

import allweather.api.user.CreateUserRequest;

public interface RegistrationService {

    String registerNewUser(CreateUserRequest userDto);
}
