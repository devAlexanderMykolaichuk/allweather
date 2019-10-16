package allweather.gateways.elasticsearch;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.springframework.stereotype.Component;

import java.io.IOException;

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

        CreateIndexRequest createIndexRequest = new CreateIndexRequest("test_index2");
        createIndexRequest.settings(Settings.builder()
                .put("index.number_of_shards", 3)
                .put("index.number_of_replicas", 2)
        );

        createIndexRequest.mapping(indexBuilder.getOpenWeatherIndexBuilder());
        //createIndexRequest.source("{}", XContentType.JSON);
        CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse.toString());

    }
}
