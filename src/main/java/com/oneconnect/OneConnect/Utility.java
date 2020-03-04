package com.oneconnect.OneConnect;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.util.ResourceUtils;

import java.io.*;

public class Utility {
    public JSONArray jsonArrayGenerator(String fileName) {
        File file = null;
        JSONArray jsonArray;
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
            jsonArray = new JSONArray();
        }catch (IOException e) {
            e.printStackTrace();
            jsonArray = new JSONArray();
        } catch (ParseException e) {
            e.printStackTrace();
            jsonArray = new JSONArray();
        }
        return jsonArray;
    }

    public boolean numberChecker(String number) {
        boolean valid = false;
        if (number!= null && number.length() > 0){
            try {
                int intNum = Integer.parseInt(number);
                valid = intNum >= 0;
            } catch(NumberFormatException e) {
                System.out.println(e);
            }
        }
        return valid;
    }

    public boolean jsonWriter(String jsonString, String fileName) {
        //We save to the temp because that allows for permanent data storage...storing to resources does not
        boolean successfulSave;
        try(FileWriter fileWriter = new FileWriter("C:/temp/"+fileName)){
            fileWriter.write(jsonString);
            fileWriter.flush();
            successfulSave = true;
        }  catch(IOException e) {
            System.out.println(e);
            successfulSave = false;
        }
        return successfulSave;
    }

    public String newIdGenerator() {
        File file;
        String dbFile = "Database/lastId.txt";
        String longStore = "C:/temp/lastId.txt";
        String number = "NaN";
        try {
            File longTermStore = new File (longStore);
            if (!longTermStore.exists()) {
                file= ResourceUtils.getFile("classpath:"+dbFile);
            } else {
                file = longTermStore;
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            number = reader.readLine();
            int temp = Integer.parseInt(number);
            temp++;
            number = temp+"";
            jsonWriter(number, "lastId.txt");
            reader.close();
        } catch(FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        return number;
    }
}
