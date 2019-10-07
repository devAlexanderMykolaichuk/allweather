package allweather.api.user;

import lombok.Data;

@Data
public class CreateUserRequest {

    private String login;

    private String password;

    private String email;
}
