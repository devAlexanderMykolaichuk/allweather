package allweather.gateways.openweather;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Test extends GenericJson {

        @Key
        private Long userId;
        @Key
        private Long id;

        private String title;
        @Key
        private boolean completed;

}
