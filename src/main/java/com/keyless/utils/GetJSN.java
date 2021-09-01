package com.keyless.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class GetJSN {

    public static final String folder_path = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "mobileelements" + File.separator;
    public String fileName = "";
    public String fileData = null;

    public GetJSN(String fileName) {
        this.fileName = folder_path + fileName;
        System.out.println(this.fileName);
        readFileData();
    }

    public void readFileData() {
        FileInputStream fis;
        StringBuilder sb = null;
        try {
            fis = new FileInputStream(fileName);

            byte[] buffer = new byte[10];
            sb = new StringBuilder();

            while (fis.read(buffer) != -1) {
                sb.append(new String(buffer));
                buffer = new byte[10];
            }
            fis.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        fileData = sb.toString();
        System.out.println(fileData);
    }

    public String GetValueFromParent(String parent) {
        String value = null;
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(fileData);
            System.out.println(json.get(parent));

            JSONArray solutions = (JSONArray) json.get("login");

            Iterator iterator = solutions.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return value;
    }

    public String parselogin() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("/Users/apple/eclipse-workspace/OaksTestAutomation/resources/mobileelements/android/Devices.json");
        JSONParser jsonParserObject = new JSONParser();
        Object obj = jsonParserObject.parse(reader);
        JSONArray userlist = (JSONArray) obj;
        String value = null;
        System.out.println(userlist.size());
        for (int i = 0; i < userlist.size(); i++) {
            JSONArray arr = (JSONArray) userlist.get(i);
            Object[] bb = arr.toArray();
            for (int a = 0; a < bb.length; a++) {
                System.out.println(bb[a].toString());
            }
            //System.out.println(arr.toArray());
            //JSONObject emp = (JSONObject) userlist.get(i);
            //System.out.println(emp.containsKey("device"));

            //value= (String)employeeObject.get("device")	;
        }
        return value;

        //JSONObject json = (JSONObject) parser.parse(reader);
        //JSONObject employeeObject = (JSONObject) json.get("device");
        //String value= (String)employeeObject.get("device_button")	;
        //return value;

    }

    public String GetValueFromJSON(String key) {
        String value = null;
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(fileData);
            value = json.get(key).toString();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return value;
    }

    public By GetElementFromJSON(String key) {
        String[] by = GetValueFromJSON(key).split(":");
        if (by[0].equalsIgnoreCase("xpath")) {
            return By.xpath(by[1]);
        } else if (by[0].equalsIgnoreCase("id")) {
            return By.id(by[1]);
        }

        return null;
    }


}
