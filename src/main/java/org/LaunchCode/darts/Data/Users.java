package org.LaunchCode.darts.Data;

import org.apache.tomcat.util.json.JSONParser;

import java.io.FileReader;
import org.json.simple.JSONObject

public class Users {
    private JSONObject userData;
    private static Boolean dataLoaded = false;


    public Boolean loadData () {
        if(!dataLoaded) {
            Object userFile = new JSONParser().parse(new FileReader(users.json));
            userData = (JSONObject) userFile;
        }
    }

    public Object getUserData () {
        return userData;
    }
    public Boolean getDataLoaded () {
        return dataLoaded;
    }


}
