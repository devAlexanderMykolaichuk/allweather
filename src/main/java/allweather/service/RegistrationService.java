package allweather.service;

import allweather.api.NewUserDto;

public interface RegistrationService {

    String registerNewUser(NewUserDto userDto);
}
