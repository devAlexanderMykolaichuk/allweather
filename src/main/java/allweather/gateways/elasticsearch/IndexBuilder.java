package allweather.gateways.elasticsearch;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class IndexBuilder {
    public XContentBuilder getTestIndexBuilder() throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        {
            builder.startObject("test");
            {
                builder.field("test", "text");
            }
            builder.endObject();
        }
        builder.endObject();
        return builder;
    }

    public XContentBuilder getOpenWeatherIndexBuilder() throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder();

        //todo: fix structure

        builder.startObject();
        {
            builder.startObject("properties");
            {
                builder.startObject("service_name").field("type", "text").endObject();

                builder.startObject("city_name").field("type", "text").endObject();
//
                builder.startObject("city_id").field("type", "long").endObject();
//
                builder.startObject("city_timezone").field("type", "integer").endObject();
//
                builder.startObject("request_time").field("type", "date").endObject();
//
                builder.startObject("visibility").field("type", "integer").endObject();
//
                builder.startObject("base").field("type", "text").endObject();

                builder.startObject("sys_type").field("type", "long").endObject();

                builder.startObject("sys_id").field("type", "long").endObject();

                builder.startObject("sys_message").field("type", "double").endObject();

                builder.startObject("sys_country").field("type", "text").endObject();

                builder.startObject("sunrise").field("type", "long").endObject();

                builder.startObject("sunset").field("type", "long").endObject();

                builder.startObject("clouds").field("type", "integer").endObject();

                builder.startObject("wind_speed").field("type", "integer").endObject();

                builder.startObject("wind_deg").field("type", "integer").endObject();

                builder.startObject("pressure").field("type", "integer").endObject();

                builder.startObject("humidity").field("type", "integer").endObject();

                builder.startObject("temp").field("type", "double").endObject();

                builder.startObject("temp_min").field("type", "double").endObject();

                builder.startObject("temp_max").field("type", "double").endObject();

                builder.startObject("lon").field("type", "geo_point").endObject();

                builder.startObject("lat").field("type", "geo_point").endObject();

                builder.startObject("weather_id").field("type", "integer").endObject();

                builder.startObject("weather_main").field("type", "text").endObject();

                builder.startObject("weather_description").field("type", "text").endObject();

            }
            builder.endObject();
        }
        builder.endObject();

        return builder;
    }
}
