package com.qa.util;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigJsonFileReader {

    private String pathToJsonFile;
    public ConfigJsonFileReader (String pathToJsonFile){
        this.pathToJsonFile = pathToJsonFile;
    }

    /**
     * @link https://www.youtube.com/watch?v=U-5VHRvOFpA
//     * @param pathToJsonFile -Sample ./src/main/java/com/pages/herokapp/DynamicLoadingPageSelectors.json
     * @param objectName
     * @param objKey
     * @return - it returns object key value
     * @throws IOException
     * @throws ParseException
     * "objectName": {
     *     "objKey": "div#finish > h4"
     *   }
     */
    public String getSelectorFromJson(String objectName, String objKey) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(this.pathToJsonFile);

        Object obj = jsonParser.parse(reader);

        JSONObject theJsonObject = (JSONObject) obj;

        JSONObject jsonObject = (JSONObject)theJsonObject.get(objectName);

        return (String) jsonObject.get(objKey);
    }
}
