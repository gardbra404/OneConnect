package com.oneconnect.OneConnect;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Utility {
    public JSONArray jsonArrayGenerator(String fileName) {
        File file = null;
        JSONArray jsonArray = null;
        JSONParser jsonParser = new JSONParser();
        String databaseFileName = "Database/"+fileName;
        String longStore = "C:/temp/"+fileName;
        try {
            File longTermFile = new File(longStore);
            if(!longTermFile.exists()){
                file = ResourceUtils.getFile("classpath:"+databaseFileName);
            } else {
                file = longTermFile;
            }
            FileReader reader = new FileReader(file);
            Object obj = jsonParser.parse(reader);
            jsonArray = (JSONArray) obj;
        } catch(FileNotFoundException e) {
            System.out.println(e);
            jsonArray = null;
        }catch (IOException e) {
            e.printStackTrace();
            jsonArray = null;
        } catch (ParseException e) {
            e.printStackTrace();
            jsonArray = null;
        }
        return jsonArray;
    }
}
