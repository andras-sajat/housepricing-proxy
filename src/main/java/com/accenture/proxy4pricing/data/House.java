package com.accenture.proxy4pricing.data;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {

    private String ac;
    private String address;
    private String area;
    private String balcony;
    private String comfortLevel;
    private String condition;
    private String elevator;
    private String energyEfficiency;
    private String garden;
    private String id;
    private String internalHeight;
    private String loft;
    private String numberOfRooms;
    private String price;
    private String readyForDisabled;
    private String storiesOfHouse;
    private String story;
    private String yearBuilt;

}