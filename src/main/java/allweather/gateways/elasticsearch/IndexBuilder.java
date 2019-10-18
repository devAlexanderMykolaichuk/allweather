package allweather.gateways.elasticsearch;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class IndexBuilder {

    public XContentBuilder getOpenWeatherIndexBuilder() throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder();

        builder.startObject();
        {
            builder.startObject("properties");
            {
                builder.startObject("service_name").field("type", "text").endObject();

                builder.startObject("requestTime").field("type", "date").endObject();

                builder.startObject("dt").field("type", "long").endObject();

                builder.startObject("city_name").field("type", "text").endObject();
//
                builder.startObject("city_id").field("type", "long").endObject();

                builder.startObject("visibility").field("type", "integer").endObject();
//
                builder.startObject("base").field("type", "text").endObject();

                builder.startObject("main").field("type", "object").endObject();

                builder.startObject("weather").field("type", "nested").endObject();

                builder.startObject("clouds").field("type", "object").endObject();

                builder.startObject("wind").field("type", "object").endObject();

                builder.startObject("sys").field("type", "object").endObject();

                builder.startObject("coord").field("type", "object").endObject();

                builder.startObject("forecasts").field("type", "nested").endObject();

            }
            builder.endObject();
        }
        builder.endObject();

        return builder;
    }
}
