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

    public String toString() {
        return "\n    Id: "+id+
        "\n    Lot area: "+lotArea+
        "\n    Pool area: "+poolArea+
        "\n    Overall quality: "+overallQuality+
        "\n    Year built: "+yearBuilt;

    }

}