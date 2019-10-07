package allweather.api;

import lombok.Data;

@Data
public class NewUserDto {

    private String login;

    private String password;

    private String email;
}
