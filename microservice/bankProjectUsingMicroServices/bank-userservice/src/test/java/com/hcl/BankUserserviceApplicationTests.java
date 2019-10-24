package com.hcl;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class BankUserserviceApplicationTests {
	@LocalServerPort
    int randomServerPort;

	@Test
	public void validGetUserByusername()  throws URISyntaxException 
	{
		 RestTemplate restTemplate = new RestTemplate();
	        
	        final String baseUrl = "http://localhost:"+randomServerPort+"/user/ggdggdfg/get";
	        URI uri = new URI(baseUrl);

	       try{
	    	   ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	        	 Assert.assertEquals(200, result.getStatusCodeValue());
	             //Assert.assertEquals(true, result.getBody().contains(""));
	    	   
	       }
	       catch (HttpClientErrorException ex) {
	    	   Assert.assertEquals(400, ex.getRawStatusCode());
	            Assert.assertEquals(true, ex.getResponseBodyAsString().contains("Missing request header"));
		}
		 
		    
	}

}
