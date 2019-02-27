package com.accenture.proxy4pricing.data;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {

    private String id;
    private String lotArea;
    private String yearBuilt;
    private String poolArea;
    private String overallQuality;
    private String houseStyle;
    private String overallCond;
    private String fullBath;
    private String yearRemodAdd;
    private String bedroomAbvGr;

    public String toString() {
        return "\n    Id: "+id+
        "\n    Lot area: "+lotArea+
        "\n    Pool area: "+poolArea+
        "\n    Overall quality: "+overallQuality+
        "\n    Overall condition: "+overallCond+
        "\n    Renovated: "+yearRemodAdd+
        "\n    Bathrooms: "+fullBath+
        "\n    Bedrooms: "+bedroomAbvGr+
        "\n    House style: "+houseStyle+
        "\n    Year built: "+yearBuilt;

    }

}