package com.accenture.proxy4pricing.data;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDetails {

    private House house;
    private String estimateServiceUrl;
    private String serviceKey;
    
}