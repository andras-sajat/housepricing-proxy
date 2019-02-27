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
import java.util.Arrays;
import java.util.HashMap;
import java.lang.StringBuilder;
import com.accenture.proxy4pricing.data.House;

@RestController
class Controller {

    private HashMap<String, String> params;

    final String messageStart = "{\"Inputs\": {\"input1\":[{";
    
    final String messageEnd = "}],},\"GlobalParameters\":  {}}";

    @CrossOrigin()
    @RequestMapping(value="/greeting", consumes="application/json")
    @ResponseBody
    public String greeting(@RequestBody House house) {
        System.out.println("Input house parameters: " + house);
        return getPrice(house);
    }

    private String getPrice(House house)
    {

        final String uri = "https://ussouthcentral.services.azureml.net/workspaces/cb2531634b964c36ad54858023e650d0/services/f098f90df7834679905ee5a312a6518e/execute?api-version=2.0&format=swagger";
        
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth("SVXG6FS82Loy71Y6epKWs32aL/Fx7SmB0CWwHiXswIWbWFfS+bmoAbvhd7rFJCDVJDHmlab6zh3TI/6UGQuS7Q==");
        HttpEntity<String> entity = new HttpEntity<String>(assembledMessage(house), headers);
        
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
        
        System.out.println(result.getBody());

        return(result.getBody());
    }

    private String assembledMessage(House house) {
        initParams();
        params.put("Id", house.getId());
        params.put("LotArea", house.getLotArea());
        params.put("YearBuilt", house.getYearBuilt());
        params.put("PoolArea", house.getPoolArea());
        params.put("OverallQual", house.getOverallQuality());
        params.put("OverallCond", house.getOverallCond());
        params.put("BedroomAbvGr", house.getBedroomAbvGr());
        params.put("HouseStyle", house.getHouseStyle());
        params.put("FullBath", house.getFullBath());
        params.put("YearRemodAdd", house.getYearRemodAdd());
        StringBuilder sb = new StringBuilder(messageStart);
        params.forEach((key, value) -> {
            sb.append("\n\"").append(key).append("\": \"").append(value).append("\",");
        });
        sb.append("\n\"").append("SalePrice").append("\": \"").append("0").append("\"");
        
        sb.append(messageEnd);
        System.out.println("Stringbuilder: "+sb);

        return sb.toString();
    }

    private void initParams() {
        params = new HashMap<>();
        params.put("Id","1");
        params.put("MSSubClass","60");
        params.put("MSZoning","RL");
        params.put("LotFrontage","65");
        params.put("LotArea","8450");
        params.put("Street","Pave");
        params.put("Alley","NA");
        params.put("LotShape","Reg");
        params.put("LandContour","Lvl");
        params.put("Utilities","AllPub");
        params.put("LotConfig","Inside");
        params.put("LandSlope","Gtl");
        params.put("Neighborhood","CollgCr");
        params.put("Condition1","Norm");
        params.put("Condition2","Norm");
        params.put("BldgType","1Fam");
        params.put("HouseStyle","2Story");
        params.put("OverallQual","7");
        params.put("OverallCond","5");
        params.put("YearBuilt","2003");
        params.put("YearRemodAdd","2003");
        params.put("RoofStyle","Gable");
        params.put("RoofMatl","CompShg");
        params.put("Exterior1st","VinylSd");
        params.put("Exterior2nd","VinylSd");
        params.put("MasVnrType","BrkFace");
        params.put("MasVnrArea","196");
        params.put("ExterQual","Gd");
        params.put("ExterCond","TA");
        params.put("Foundation","PConc");
        params.put("BsmtQual","Gd");
        params.put("BsmtCond","TA");
        params.put("BsmtExposure","No");
        params.put("BsmtFinType1","GLQ");
        params.put("BsmtFinSF1","706");
        params.put("BsmtFinType2","Unf");
        params.put("BsmtFinSF2","0");
        params.put("BsmtUnfSF","150");
        params.put("TotalBsmtSF","856");
        params.put("Heating","GasA");
        params.put("HeatingQC","Ex");
        params.put("CentralAir","Y");
        params.put("Electrical","SBrkr");
        params.put("1stFlrSF","856");
        params.put("2ndFlrSF","854");
        params.put("LowQualFinSF","0");
        params.put("GrLivArea","1710");
        params.put("BsmtFullBath","1");
        params.put("BsmtHalfBath","0");
        params.put("FullBath","2");
        params.put("HalfBath","1");
        params.put("BedroomAbvGr","3");
        params.put("KitchenAbvGr","1");
        params.put("KitchenQual","Gd");
        params.put("TotRmsAbvGrd","8");
        params.put("Functional","Typ");
        params.put("Fireplaces","0");
        params.put("FireplaceQu","NA");
        params.put("GarageType","Attchd");
        params.put("GarageYrBlt","2003");
        params.put("GarageFinish","RFn");
        params.put("GarageCars","2");
        params.put("GarageArea","548");
        params.put("GarageQual","TA");
        params.put("GarageCond","TA");
        params.put("PavedDrive","Y");
        params.put("WoodDeckSF","0");
        params.put("OpenPorchSF","61");
        params.put("EnclosedPorch","0");
        params.put("3SsnPorch","0");
        params.put("ScreenPorch","0");
        params.put("PoolArea","0");
        params.put("PoolQC","NA");
        params.put("Fence","NA");
        params.put("MiscFeature","NA");
        params.put("MiscVal","0");
        params.put("MoSold","2");
        params.put("YrSold","2008");
        params.put("SaleType","WD");
        params.put("SaleCondition","Normal");
    }

}