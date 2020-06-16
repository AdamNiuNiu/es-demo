package com.example.es.esdemo;

import com.example.es.esdemo.pojo.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsdemoApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println("=====测试方法=====");
    }

    private RestHighLevelClient restHighLevelClient;

    @Before
    public void init() {
        RestClientBuilder restClientBuilder = RestClient.builder(
                new HttpHost("192.168.106.129", 9200),
                new HttpHost("192.168.106.129", 9201)
        );

        this.restHighLevelClient = new RestHighLevelClient(restClientBuilder);
    }

    @After
    public void close() throws Exception {
        this.restHighLevelClient.close();
    }


    @Test
    public void testSave() throws Exception {

        Map<String, Object> data = new HashMap<>();
        data.put("id", 2002);
        data.put("title", "南京东路 二室一厅");
        data.put("price", 4000);

        IndexRequest indexRequest = new IndexRequest("haoke", "house").source(data);

        IndexResponse response = this.restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);

        System.out.println("id -> " + response.getId());
        System.out.println("version -> " + response.getVersion());
        System.out.println("result -> " + response.getResult());
    }


    @Test
    public void testSave2() {
        User user = new User();
        user.setId(1001L);
        user.setAge(20);
        user.setName("张三");
        user.setHobby("足球、篮球、听音乐");
        IndexQuery indexQuery = new IndexQueryBuilder().withObject(user).build();
//        String index = this.restHighLevelClient.index(indexQuery);
//        System.out.println(index);
    }

}
