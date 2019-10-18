package allweather.controller;


import allweather.gateways.elasticsearch.ESClient;
import allweather.service.OWService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("/test")
public class TestController {


    private final OWService owService;

    private final ESClient esClient;

    @Autowired
    public TestController(OWService owService, ESClient esClient) {
        this.owService = owService;
        this.esClient=esClient;
    }

    @GetMapping("/test")
    public void getTestOW() throws IOException {

        owService.updateService();

    }
}
