package com.accenture.proxy4pricing.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Collections;
import java.util.HashMap;
import java.lang.StringBuilder;
import com.accenture.proxy4pricing.data.House;
import com.accenture.proxy4pricing.data.RequestDetails;

@RestController
class Controller {

    private static final String MESSAGE_START = "{\"Inputs\": {\"input1\":[{";
    private static final String MESSAGE_END = "}]},\"GlobalParameters\":  {}}";

    private HashMap<String, String> params;

    @CrossOrigin()
    @RequestMapping(value="/greeting", consumes="application/json")
    @ResponseBody
    public String greeting(@RequestBody RequestDetails request) {
        System.out.println("Service URL: " + request.getEstimateServiceUrl());
        System.out.println("Service key: " + request.getServiceKey());
        System.out.println("Input house parameters: " + request.getHouse());
        return getPrice(request);
    }

    private String getPrice(RequestDetails request)
    {

        String uri = request.getEstimateServiceUrl();
        
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(request.getServiceKey());
        String message = assembledMessage(request.getHouse());
        System.out.println(headers);
        System.out.println(message);
        HttpEntity<String> entity = new HttpEntity<>(message, headers);
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
        System.out.println(result.getBody());
        return(result.getBody());
    }

    private String assembledMessage(House house) {
        initParams();
        params.put("Column 0","1");  
        params.put("AC", house.getAc());  
        params.put("address", house.getAddress());  
        params.put("area", house.getArea());  
        params.put("balcony", house.getBalcony());  
        params.put("comfortLevel", house.getComfortLevel());  
        params.put("condition",  house.getCondition());  
        params.put("elevator", house.getElevator());  
        params.put("energyEfficiency", house.getEnergyEfficiency());  
        params.put("garden", house.getGarden());  
        params.put("id","0");  
        params.put("internalHeight", house.getInternalHeight());  
        params.put("loft", house.getLoft());  
        params.put("numberOfRooms", house.getNumberOfRooms());  
        params.put("readyForDisabled", house.getReadyForDisabled());  
        params.put("storiesOfHouse", house.getStoriesOfHouse());  
        params.put("story", house.getStory());  
        params.put("yearBuilt", house.getYearBuilt());

        StringBuilder sb = new StringBuilder(MESSAGE_START);
        params.forEach((key, value) -> sb.append("\n\"").append(key).append("\": \"").append(value).append("\","));
        sb.append("\n\"").append("price").append("\": \"").append("0").append("\"");        
        sb.append(MESSAGE_END);
        return sb.toString();
    }

    private void initParams() {
        params = new HashMap<>();
        params.put("Column 0","1");  
        params.put("AC","false");  
        params.put("address","7. district (Budapest)");  
        params.put("area","25");  
        params.put("balcony","1");  
        params.put("comfortLevel","below average");  
        params.put("condition","needs renovation");  
        params.put("elevator","false");  
        params.put("energyEfficiency","unknown");  
        params.put("garden","false");  
        params.put("id","0");  
        params.put("internalHeight","at least 3 m");  
        params.put("loft","false");  
        params.put("numberOfRooms","1");  
        params.put("readyForDisabled","false");  
        params.put("storiesOfHouse","3");  
        params.put("story","1");  
        params.put("yearBuilt","unknown");
    }

}