package allweather.gateways.elasticsearch;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Component
public class ESClient {

    private final RestHighLevelClient client;

    private final ObjectMapper mapper;

    private final IndexBuilder indexBuilder;

    public ESClient(RestHighLevelClient client, ObjectMapper objectMapper, IndexBuilder indexBuilder){
        this.client=client;
        this.mapper=objectMapper;
        this.indexBuilder=indexBuilder;
    }

    public void createIndex() throws IOException {

        CreateIndexRequest createIndexRequest = new CreateIndexRequest("test_index4");
        createIndexRequest.settings(Settings.builder()
                .put("index.number_of_shards", 3)
                .put("index.number_of_replicas", 2)
        );

        createIndexRequest.mapping(indexBuilder.getOpenWeatherIndexBuilder());
        //createIndexRequest.source("{}", XContentType.JSON);
        CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse.toString());

    }

    public void insertIntoIndex() throws IOException {
        Map<String, Object> map = new HashMap<>();

        map.put("service_name", "OpenWeatherData");
        map.put("request_time", new LocalDateTime().toString());

        IndexRequest indexRequest = new IndexRequest("test_index4");
        indexRequest.id("1");
        indexRequest.source(map);
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.toString());
    }

    public void getIndex() throws IOException {
        GetRequest getRequest = new GetRequest("test_index4" );
        getRequest.id("1");
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(getResponse.toString());
    }
}
