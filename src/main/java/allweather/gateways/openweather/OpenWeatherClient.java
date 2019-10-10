package allweather.gateways.openweather;


import java.io.IOException;

public class OpenWeatherClient extends AbstractClient{


    public String getTest() throws IOException {
        return get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk");
    }


    public static void main(String[] args) throws IOException {
       OpenWeatherClient client = new OpenWeatherClient();
        System.out.println(client.getTest());
    }

}
