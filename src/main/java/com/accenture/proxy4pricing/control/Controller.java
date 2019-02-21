package com.accenture.proxy4pricing.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Arrays;
import com.accenture.proxy4pricing.data.House;

@RestController
class Controller {

    @CrossOrigin(origins = {"http://localhost:4200"})
    @RequestMapping(value="/greeting", consumes="application/json")
    @ResponseBody
    public String greeting(@RequestBody House body) {
        System.out.println("Input: " + body.getId());
        return getPrice();
    }

    private String getPrice()
    {
        final String message = "{\"Inputs\":"+ 
                "{\"input1\": "+
                    "{"+
                        "\"ColumnNames\": [\"make\", \"fuel\", \"doors\", \"body\", \"drive\", \"weight\", \"engine-size\", \"bhp\", \"mpg\", \"price\"], "+
                        "\"Values\": [[\"alfa-romero\", \"value\", \"value\", \"value\", \"value\", \"0\", \"0\", \"0\", \"0\", \"0\"], [\"value\", \"value\", \"value\", \"value\", \"value\", \"0\", \"0\", \"0\", \"0\", \"0\"]]"+
                    "}"+                    
                "},"+ 
            "\"GlobalParameters\": {}"+
            "}";

        final String uri = "https://ussouthcentral.services.azureml.net/workspaces/cb2531634b964c36ad54858023e650d0/services/b6d4e92b97f042fb9ee423d2a6acaf18/execute?api-version=2.0&details=true";
        
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth("uQpZ5qC4Dhrf/TA6gtwXkDTCCWLNCp5OfB1iMfqJArmvzy6v0IN4QZNTQQeyX0BFsZLIY9GeRgbYIArDLnnE8A==");
        HttpEntity<String> entity = new HttpEntity<String>(message, headers);
        
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
        
        System.out.println(result.getBody());

        return(result.getBody());
    }

}