package com.accenture.proxy4pricing.data;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class House {

    private String id;
    private String lotArea;
    private String yearBuilt;
    private String poolArea;

    public String toString() {
        return "\n    Id: "+id+
        "\n    Lot area: "+lotArea+
        "\n    Pool area: "+poolArea+
        "\n    Year built: "+yearBuilt;

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setLotArea(String lotArea) {
        this.lotArea = lotArea;
    }

    public String getLotArea() {
        return lotArea;
    }
    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getPoolArea() {
        return poolArea;
    }
    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public String getYearBuilt() {
        return yearBuilt;
    }

}