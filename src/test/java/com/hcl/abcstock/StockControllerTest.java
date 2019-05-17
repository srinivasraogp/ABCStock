package com.hcl.abcstock;

import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.abcstock.models.Stock;
import com.hcl.abcstock.models.User;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StockControllerTest {

	@LocalServerPort
    private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
    
    @Test
    public void testGetProductListSuccess() throws URISyntaxException
    {
    	final String baseUrl = "http://localhost:" + port + "/abcstock/api/stocks";
        ResponseEntity<List<Stock>> response = restTemplate.exchange(baseUrl,
        		  HttpMethod.GET,
        		  null,
        		  new ParameterizedTypeReference<List<Stock>>(){});
        		List<Stock> employees = response.getBody();
       Assert.assertEquals(3, employees.size()); 		
    }
}
