package allweather.gateways.elasticsearch;



import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.springframework.stereotype.Component;

import java.io.IOException;


import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

@Component
@Log4j2
public class ESClient {

    private final RestHighLevelClient client;

    private final ObjectMapper mapper;

    private final IndexBuilder indexBuilder;


    public ESClient(RestHighLevelClient client, ObjectMapper objectMapper, IndexBuilder indexBuilder){
        this.client=client;
        this.mapper=objectMapper;
        this.indexBuilder=indexBuilder;
    }


    public void insertIndexData(Map<String, Object> map) throws IOException {


        LocalDate localDate = LocalDate.now();

        String sandboxIndex = "sandbox-openweather"+"-"+localDate.toString();



        if (!ifIndexExist(sandboxIndex)){
            log.info("index "+ sandboxIndex+ " not exist, going to create");
            createIndex(sandboxIndex);
        }
        IndexRequest indexRequest = new IndexRequest(sandboxIndex);
        UUID uuid = UUID.randomUUID();
        indexRequest.id(uuid.toString());
        indexRequest.source(map);
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.toString());
    }

    public void getIndexData(String index) throws IOException {


        GetRequest getRequest = new GetRequest(index);
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(getResponse.toString());
    }

    private boolean ifIndexExist(String index) throws IOException {
        return client.indices().exists(new GetIndexRequest(index), RequestOptions.DEFAULT);
    }

    private void createIndex(String index) throws IOException {

        CreateIndexRequest createIndexRequest = new CreateIndexRequest(index);
        createIndexRequest.settings(Settings.builder()
                .put("index.number_of_shards", 3)
                .put("index.number_of_replicas", 2)
        );

        createIndexRequest.mapping(indexBuilder.getOpenWeatherIndexBuilder());
        CreateIndexResponse r =  client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        log.info("index " +index+"  was created: "+r.isAcknowledged());
    }
}
