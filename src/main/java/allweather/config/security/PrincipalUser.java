package allweather.config.security;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrincipalUser {

    private String login;
    private String email;
}
