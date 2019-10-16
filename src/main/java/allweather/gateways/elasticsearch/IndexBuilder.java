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
                builder.startObject("name").field("type", "text").endObject();

                builder.field("id").field("type", "long").endObject();

                builder.startObject("timezone").field("type", "integer").endObject();

                builder.startObject("request_time").field("type", "date").endObject();

                builder.startObject("visibility").field("type", "integer").endObject();

                builder.startObject("base").field("type", "text").endObject();

                builder.startObject("sys");
                {
                    builder.startObject("type").field("type", "integer").endObject();
                    builder.startObject("id").field("type", "integer").endObject();
                    builder.startObject("message").field("type", "double").endObject();
                    builder.startObject("country").field("type", "text").endObject();
                    builder.startObject("sunrise").field("type", "long").endObject();
                    builder.startObject("sunset").field("type", "long").endObject();
                }
                builder.endObject();

                builder.startObject("clouds");
                {
                    builder.startObject("all").field("type", "integer").endObject();
                }
                builder.endObject();

                builder.startObject("wind");
                {
                    builder.startObject("speed").field("speed", "integer").endObject();
                    builder.startObject("deg").field("type", "integer").endObject();
                }
                builder.endObject();

                builder.startObject("main");
                {
                    builder.startObject("pressure").field("type", "integer").endObject();
                    builder.startObject("humidity").field("type", "integer").endObject();
                    builder.startObject("temp").field("type", "double").endObject();
                    builder.startObject("temp_min").field("type", "double").endObject();
                    builder.startObject("temp_max").field("type", "double").endObject();
                }
                builder.endObject();

                builder.startObject("coordinate");
                {
                    builder.startObject("lon").field("type", "text").endObject();
                    builder.startObject("lat").field("type", "text").endObject();
                }
                builder.endObject();

                builder.startObject("weather");
                {
                    builder.startObject("id").field("type", "integer").endObject();
                    builder.startObject("main").field("type", "text").endObject();
                    builder.startObject("description").field("type", "text").endObject();
                    builder.startObject("icon").field("type", "text").endObject();
                }
                builder.endObject();
            }
            builder.endObject();
        }
        builder.endObject();

        return builder;
    }
}
